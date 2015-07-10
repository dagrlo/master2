package es.uv.isw.sparrow.registereduser.follow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to follow registered users.
 */
@WebServlet("/Follow")
public class Follow extends HttpServlet {
	
	private static final long serialVersionUID = 1L; // Identificador
	public static final String USER_PARAM = "userId"; // Parámetro para poder recoger el usuario directamente desde la sesión
	public static final String FOLLOWED_PARAM = "followed"; // Parámetro para indicar que se sigue a un usuario (este sí que lo tendremos que coger del jsp)
	public static final String FOLLOW_ATTR = "follow"; // Nombre del atributo para indicar que se sigue a alguien
    
    public Follow() {
        super();
    } // Follow()

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Leemos los parámetros que contiene la información de quién es el usuario y a quién se va a seguir desde el JSP:
		int user = (int) request.getSession(true).getAttribute(USER_PARAM);
		String followed = request.getParameter(FOLLOWED_PARAM);
		
		// Nos valemos de la herramienta que gestiona el follow:
		FollowTool followTool = new FollowTool(user, Integer.parseInt(followed));
		
		// Guardamos una copia de este atributo en el contexto de la consulta (por si tenemos que acceder desde el JSP):
		request.setAttribute(FOLLOW_ATTR, followTool);
		
		// Nos vamos a la pantalla donde muestra los usuarios a los que estamos siguiendo (por ejemplo, así corroboramos directamente que se ha hecho el follow):
		String nextPage = "/mainPage";                           // AHORA VAMOS DIRECTAMENTE A LA PÁGINA PRINCIPAL. HAY QUE CAMBIAR ESTO !!!
		
		// Si el usuario tiene el mismo id que el seguidor, mostramos un error:
		if (followTool.isUserFollowed()) {
			nextPage = "/followError.jsp";
		}
		
		// Le damos el control a la vista correspondiente:
		request.getRequestDispatcher(nextPage).forward(request, response);
	} // doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); // Delegamos en la petición GET (e.g.: se puede hacer una petición POST en vez de GET, para que no se vean las queryString en la barra de direcciones del navegador)
	} // doPost()

} // Follow