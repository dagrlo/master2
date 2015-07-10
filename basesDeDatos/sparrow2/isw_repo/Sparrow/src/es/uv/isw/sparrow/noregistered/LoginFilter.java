package es.uv.isw.sparrow.noregistered;

import es.uv.isw.sparrow.bean.UserBean;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/WEB-INF/*")
@WebFilter("/*")
public class LoginFilter implements Filter {
	private static final long serialVersionUID = 1L;
	private static final String USERNAME_PARAM = "username";
	private static final String PASSWORD_PARAM = "password";
	private static final String USERBEAN_ATTR = "userbean";
	private static final String CONTROLLER_PREFIX = "/WEB-iNF";
	
	private static final String USER_ID = "userId";
	private static final String USER_NAME = "userName";
	private static final String USER_IS_LOGGED = "userIsLogged";
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("EN EL FILTRO DEL LOGIN===============");
		//Como aqui se trata con HttpServlet, se hace un cast
		HttpServletRequest rq = (HttpServletRequest)request;
		HttpServletResponse responseHTTP = (HttpServletResponse)response;
		HttpServletRequest requestHTTP = (HttpServletRequest)request;

		String nextPage = requestHTTP.getRequestURI().substring(requestHTTP.getContextPath().length()).replaceAll(CONTROLLER_PREFIX,"");
		//System.out.println("next: " + nextPage);
		//System.out.println(rq.getRequestURI());
		String uri = rq.getRequestURI();
		
		//String uri = rq.getRequestURI();
		//String registerForm = "/Sparrow/registerForm.jsp";
		//String forgetPssw = "/Sparrow/forgetPasswordForm.jsp";
		//String showPassw="/Sparrow/showPassword.jsp";
		//String validatePassword = "/Sparrow/validatePasswordError.jsp";
		//Hay que comtemplar todos los casos y no solo la parte de loging.
		//Los casos de acceso publico y ficheros publicos
		if(uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png") || uri.endsWith(".jpg")
		|| uri.endsWith(".otf") || nextPage.equals("/registerForm.jsp") || nextPage.equals("/forgetPasswordForm.jsp")
		|| nextPage.equals("/showPassword.jsp") || nextPage.equals("/validatePasswordError")|| nextPage.equals("/ForgetPassword")){
		//	System.out.println("case 1");
			rq.getRequestDispatcher(nextPage).forward(requestHTTP, responseHTTP);	
		}
		else{
			//System.out.println("case 2");
		//first time coming
		if(nextPage.equals("/"))
		{
			System.out.println("default page");
			nextPage = "index.jsp";
		}
		
		HttpSession session = rq.getSession(true);
		UserBean userBean = (UserBean)session.getAttribute(USERBEAN_ATTR);
		boolean result;
			
		if (!userBean.isLoggedIn()) {
				// Read request parameters
			String username = rq.getParameter(USERNAME_PARAM);
			String password = rq.getParameter(PASSWORD_PARAM);
	
			if (username != null) {
					// Record username and password values
				userBean.setUsername(username);
				userBean.setPassword(password);
				session.setAttribute(USERBEAN_ATTR, userBean);
			}
			try {
				result = userBean.doLogin(username,password);
				if (!result) {
	//				String nextPage = rq.getPathInfo().replaceAll(CONTROLLER_PREFIX,"");
	//				rq.getRequestDispatcher(nextPage).forward(request, response);
					nextPage = "index.jsp";
						//System.out.println("siguiente:" + nextPage);
				} //muevo el else aqui y ya puede redireccionar como toca
				else{
					nextPage = "mainPage";
				}
			} catch (SQLException e) {
					
				e.printStackTrace();
			}
				
		}else
		{
			if(nextPage.equals("/registerForm.jsp") || nextPage.equals("/forgetPasswordForm.jsp")
					|| nextPage.equals("/showPassword.jsp") || nextPage.equals("/validatePasswordError"))
			{
				nextPage = "mainPage";
			}
		}
	
		
			//si el usuario se logea nos guardamos el id, el nombre y si esta logeado o no		 
			session.setAttribute(USER_ID, userBean.getId());
			session.setAttribute(USER_NAME, userBean.getName());
			session.setAttribute(USER_IS_LOGGED, userBean.isLoggedIn());

		// pass the request along the filter chain
		System.out.println("final next: " + nextPage);
		rq.getRequestDispatcher(nextPage).forward(requestHTTP, responseHTTP);
		}
		
		System.out.println("============fin================");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}