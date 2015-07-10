package es.uv.isw.sparrow.registereduser.unfollow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to unfollow registered users.
 */
@WebServlet("/Unfollow")
public class Unfollow extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String NEXT_PAGE_PARAM = "/mainPage";
	private static final String USER_ID = "userId";
	public static final String UNFOLLOWED_PARAM = "unfollowed";
	public static final String UNFOLLOW_ATTR = "unfollow"; 
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Unfollow() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		// recupero el usuario de la session
		int user = (int) request.getSession(true).getAttribute(USER_ID);
		System.out.println("este es el valor del user:" + user);

		// recojo el parametro del jsp
		String unfollowed = request.getParameter(UNFOLLOWED_PARAM);
		System.out.println("este es el valor de unfollowed" + unfollowed);

		// utilizo la herramienta unfollow para pruebas, donde ya he utilizado el acceso a datos de tipo DAO
		UnFollowTool unfollowTool = new UnFollowTool(user,Integer.parseInt(unfollowed));

		// guardo este atributo en la sesion
		request.setAttribute(UNFOLLOW_ATTR, unfollowTool);
		

		//redirijo a "mainPage.jsp"
		request.getRequestDispatcher(NEXT_PAGE_PARAM).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}