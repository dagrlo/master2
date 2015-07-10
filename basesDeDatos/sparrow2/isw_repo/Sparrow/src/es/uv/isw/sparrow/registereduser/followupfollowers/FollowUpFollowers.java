package es.uv.isw.sparrow.registereduser.followupfollowers;

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

/**
 * Servlet implementation class FollowUpFollowers
 */
@WebServlet("/FollowUpFollowers")
public class FollowUpFollowers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String USER_ID = "userId";
	
	private static final String UNFOLLOWED_FOLLOWERS = "unfollowedFollowers";
	private static final String NUM_UNFOLLOWED_FOLLOWERS = "numUnfollowedFollowers";
	
	private static final String NEXT_PAGE = "/followUpFollowers.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowUpFollowers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MySQLUserDAO msud;
		ArrayList<Follower> unfollowed_followers = null;
		
		HttpSession session = request.getSession();
		
		try{
			int user_id = (int)session.getAttribute(USER_ID);
			
			msud = new MySQLUserDAO();
			unfollowed_followers = msud.getFollowersNotFollowed(user_id);
			
		}catch(Exception e){
			unfollowed_followers = new ArrayList<Follower>();
		}
		
		request.setAttribute(UNFOLLOWED_FOLLOWERS, unfollowed_followers);
		request.setAttribute(NUM_UNFOLLOWED_FOLLOWERS, unfollowed_followers.size());
		request.getRequestDispatcher(NEXT_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
