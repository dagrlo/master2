package es.uv.isw.sparrow.registereduser.myfollowers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uv.isw.sparrow.bean.Follower;
import es.uv.isw.sparrow.dao.MySQLUserDAO;
import es.uv.isw.sparrow.dao.UserDAO;

/**
 * Servlet implementation class MyFollewers
 */
@WebServlet("/MyFollowers")
public class MyFollowersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER_ID = "userId";
	private static final String USER_NUM_FOLLOWED = "num_followers";
	private static final String USER_FOLLOWED = "followers";
	private static final String DELETE_FOLLOWER = "id_user";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFollowersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserDAO userDao = new MySQLUserDAO();
		int userId = (int)session.getAttribute(USER_ID);
		
		//Delete follower if pass argument
		if(request.getParameter(DELETE_FOLLOWER) != null)
		{
			try 
			{
				userDao.unfollow(userId, Integer.parseInt(request.getParameter(DELETE_FOLLOWER)));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			} 
		}
		
		ArrayList<Follower> myFollowers = new ArrayList<Follower>();
		
		try
		{
			myFollowers = userDao.getFollowings(userId);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute(USER_NUM_FOLLOWED, myFollowers.size());
		request.setAttribute(USER_FOLLOWED, myFollowers);
		
		String nextPage = "/myFollowers.jsp";
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
