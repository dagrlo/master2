package es.uv.isw.sparrow.registereduser.unfollow;

import java.sql.SQLException;

import es.uv.isw.sparrow.dao.MySQLUserDAO;

public class UnFollowTool {

	private int unfollowed;
	private int user;

	public UnFollowTool(int user, int unfollowed) {
		this.unfollowed = unfollowed;
		this.user = user;

		// creo un objeto de tipo MySqlUserDAO
		MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();

		// dejo de seguir al usuario
		try {
			mySQLUserDAO.unfollow(user, unfollowed);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 

} 