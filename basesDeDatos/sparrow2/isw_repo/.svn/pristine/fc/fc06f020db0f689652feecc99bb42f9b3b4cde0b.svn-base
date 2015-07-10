package es.uv.isw.sparrow.noregistered;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uv.isw.sparrow.bean.User;
import es.uv.isw.sparrow.dao.MySQLUserDAO;
/**
 * Servlet implementation class ForgetPasswordForm
 */
@WebServlet("/ForgetPassword")
public class ForgetPasswordForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USERNAME_PARAM = "username";
	private static final String EMAIL_PARAM = "eMail";
	private static final String PASSWORD_ATTR = "password";
	private static final String USER_ATTR = "username";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordForm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Datos recogidos.");
		String nextPage;
		String pwd = "";
		//Get parameter userName and eMail
		String userName = request.getParameter(USERNAME_PARAM);
		String eMail = request.getParameter(EMAIL_PARAM);

		System.out.println("UserName: " +userName);
		System.out.println("eMail: "+eMail);

		//HttpSession session = request.getSession(true);
		MySQLUserDAO userDAO = new MySQLUserDAO();
		
		//Parametros vacios
		if(userName.isEmpty() || eMail.isEmpty() ){
			nextPage = "/forgetPasswordForm.jsp";
		}
		else
		{	//Validar usuario y eMail
			try {
				ArrayList<User> us = userDAO.getAllUsers();
				
				for (User item : us) {
					if(userName.equals(item.getUsername()) && eMail.equals(item.geteMail())){
						pwd = item.getPassword();
						System.out.println("Los datos introducidos son correctos");
						System.out.println("password: " + pwd);
						System.out.println("UserName: "+ userName);
						request.setAttribute(USER_ATTR, userName);
						request.setAttribute(PASSWORD_ATTR, pwd);
						nextPage = "/showPassword.jsp";
						request.getRequestDispatcher(nextPage).forward(request, response);}
						
				}
			} catch (SQLException e) {
				// TODO Auto-generated password: " + pwdcatch block
				e.printStackTrace();
			}
			System.out.println("Los datos introducidos no son correctos");
			nextPage = "/validatePasswordError.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
