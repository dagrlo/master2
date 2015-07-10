package es.uv.isw.sparrow.registereduser.unfollowusers;

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
 * Servlet implementation class UnfollowFollowers
 */
@WebServlet("/UnfollowUsers")
public class UnfollowUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER_ID = "userId";
	private static final String FOLLOWED_NOT_FOLLOWING = "followed_not_following";
	private static final String NUM_FOLLOWED_NOT_FOLLOWING = "num_followed_not_following"; 

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnfollowUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MySQLUserDAO sdao;
		ArrayList<Follower> followed_not_following = null;
		
		HttpSession session = request.getSession();
		
		try{
			int user_id = (int)session.getAttribute(USER_ID);
			
			sdao = new MySQLUserDAO();
			followed_not_following = sdao.getFollowedNotFollowing(user_id);
			
		}catch(Exception e){
			followed_not_following = new ArrayList<Follower>();
		}
		
		request.setAttribute(FOLLOWED_NOT_FOLLOWING, followed_not_following);
		request.setAttribute(NUM_FOLLOWED_NOT_FOLLOWING, followed_not_following.size());
		request.getRequestDispatcher("/unfollowUsers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

