package es.uv.isw.sparrow.registereduser.follow;

import java.sql.SQLException;

import es.uv.isw.sparrow.dao.MySQLUserDAO;

/**
 * This Class is used especially to follow a registered user.
 * 
 * @author Gabriel Moreno Ibarra.
 */
public class FollowTool {
	
	private int followed;
	private int user;
	private boolean userIsFollowed;

	/**
	 * Main para hacer pruebas.
	 * @param args
	 */
	public static void main(String[] args) {
		FollowTool followTool = new FollowTool(14, 23);
		
		System.out.println("followTool.userIsFollowed: " + followTool.userIsFollowed);

	} // main()

	/**
	 * Constructor.
	 * @param user The current user managing the application.
	 * @param followed The user to follow.
	 */
	public FollowTool(int user, int followed) {
		this.followed = followed;
		this.user = user;
		
		// Instanciamos el objeto de acceso a los datos (DAO):
		MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
		
		// Comprobamos que el usuario a seguir no seamos nosotros mismos.
		// De serlo, mostraremos un mensaje de error ayudándonos de un booleano:            SE DEBERÍA TAMBIÉN DE COMPROBAR SI EL USUARIO YA SE ESTABA SIGUIENDO !!!!
		if (user == followed) {
			userIsFollowed = true;
		} else {
			userIsFollowed = false;
		}
		
		// Seguimos al usuario:
		try {
			mySQLUserDAO.follow(user, followed);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // FollowTool()

	/**
	 * @return the userIsFollowed.
	 */
	public boolean isUserFollowed() {
		return userIsFollowed;
	} // isUserFollowed()

} // FollowTool