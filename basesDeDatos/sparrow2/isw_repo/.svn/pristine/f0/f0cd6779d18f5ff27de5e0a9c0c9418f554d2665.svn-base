package es.uv.isw.sparrow.registereduser.usersearch;

import java.sql.SQLException;
import java.util.ArrayList;

import es.uv.isw.sparrow.bean.User;
import es.uv.isw.sparrow.dao.MySQLUserDAO;

/**
 * This class is used to search users.
 * 
 * @author Gabriel Moreno Ibarra.
 */
public class UserSearcherTool {
	
	/**
	 * Main para hacer pruebas.
	 * @param args
	 */
	public static void main(String[] args) {
		UserSearcherTool uS = new UserSearcherTool("a");
		
		for (int i = 0; i < uS.getUserNames().length; i++) {
			System.out.println("[" + i + "]: " + uS.getUserNames()[i] + ": " + uS.getNombres()[i] + " " + uS.getApellidos()[i]);
		}
	} // main()
	
	private ArrayList<User> registeredUsers; // Todos los usuarios registrados
	private String apellidos; // El apellido que a buscar
	private int[] indexes;
	private int count = 0;
	
	/**
	 * Constructor.
	 * @param apellidos Surname to search.
	 */
	public UserSearcherTool(String apellidos) {
		this.apellidos = apellidos; // Asignamos al atributo de la clase
		
		// Recogemos todos los usuarios registrados:
		MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
		try {
			registeredUsers = mySQLUserDAO.getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Guardamos los índices en que los apellidos contengan caracteres que coincidan con los que hay en la DB.
		// Lo hacemos así para que si ponemos 'more', pille todos los 'moreno' y 'morena', por poner un ejemplo:
		String[] apellidosInDB = new String[registeredUsers.size()];
		indexes = new int[16]; // Con 16 apellidos tenemos de sobra (en principio)
		for (int i = 0; i < registeredUsers.size(); i++) {
			if(registeredUsers.get(i).getApellidos().toLowerCase().contains(apellidos.toLowerCase())) { // Lo pasamos todo a minúsculas para mejor experiencia de usuario
				indexes[count] = i;
				count++;
			}
		}
	} // UserSearcherTool()
	
	/**
	 * @return the ids of the coincident registered users.
	 */
	public int[] getIds() {
		int[] ids = new int[count];
		for (int i = 0; i < count; i++) {
			ids[i] = registeredUsers.get(indexes[i]).getId();
		}

		return ids;
	} // getIds()
	
	/**
	 * @return the usernames of the coincident registered users.
	 */
	public String[] getUserNames() {
		String[] userNames = new String[count];
		for (int i = 0; i < count; i++) {
			userNames[i] = registeredUsers.get(indexes[i]).getUsername();
		}

		return userNames;
	} // getUserNames()
	
	/**
	 * @return the names of the coincident registered users.
	 */
	public String[] getNombres() {
		String[] nombres = new String[count];
		for (int i = 0; i < count; i++) {
			nombres[i] = registeredUsers.get(indexes[i]).getNombre();
		}

		return nombres;
	} // getNombres()
	
	/**
	 * @return the lastnames of the coincident registered users.
	 */
	public String[] getApellidos() {
		String[] apellidos = new String[count];
		for (int i = 0; i < count; i++) {
			apellidos[i] = registeredUsers.get(indexes[i]).getApellidos();
		}

		return apellidos;
	} // getApellidos()
	
	/**
	 * @return if there are users with the entered parameters.
	 */
	public boolean areThereUsers() {
		// Si la cuenta es 0, es que no ha habido ninguna coincidencia con la DB:
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	} // areThereUsers()

} // UserSearch