package es.uv.isw.sparrow.registereduser.usersearch;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to search users.
 */
@WebServlet("/UserSearcher")
public class UserSearcher extends HttpServlet {
	
	private static final long serialVersionUID = 1L; // Identificador
	public static final String SEARCH_PARAM = "usersearch"; // Parámetro de usuario a buscar (el 'name' del input text en el JSP de entrada de datos)
	public static final String UST_ATTR = "ust"; // Nombre del atributo relacionado de la herramienta para mostrar resultados de búsqueda

	public UserSearcher() {
        super();
    } // UserSearcher()

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Leemos la búsqueda realizada desde el JSP:
		String s = request.getParameter(SEARCH_PARAM);
		
		// Nos valemos de la herramienta que gestiona las búsquedas de usuario:
		UserSearcherTool uST = new UserSearcherTool(s);
		
		// Guardamos una copia de este atributo en el contexto de la consulta (para poder acceder desde el JSP desde donde mostrar los resultados):
		request.setAttribute(UST_ATTR, uST);
		
		// Si no hay ningún usuario coincidente con lo que hemos introducido por el input text, vamos a la pantalla que lo indica (y volveremos a ésta).
		// De haberlos, los mostramos en la página principal:
		String nextPage;
		if (!uST.areThereUsers()) {
			nextPage = "/noUserResults.jsp";
		} else {
			nextPage = "/userResults.jsp";
		}
		
		// Le damos el control a la vista correspondiente:
		request.getRequestDispatcher(nextPage).forward(request, response);
	} // doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); // Delegamos en la petición GET (e.g.: se puede hacer una petición POST en vez de GET, para que no se vean las queryString en la barra de direcciones del navegador)
	} // doPost()

} // UserSearcher