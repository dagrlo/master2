package es.uv.isw.sparrow.registereduser.showtopic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uv.isw.sparrow.bean.Chip;
import es.uv.isw.sparrow.bean.User;
import es.uv.isw.sparrow.dao.MySQLChipDAO;
import es.uv.isw.sparrow.dao.MySQLUserDAO;

/**
 * Servlet implementation class ShowTopic
 */
@WebServlet("/mainPage")
public class ShowTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String TOPICS_PARAM = "topics_null";
	private static final String USER_TOPICS_PARAM = "user_topics";
	
	private static final String NEXT_PAGE_ATTR = "/mainPage.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTopic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MySQLChipDAO chip_dao;
		MySQLUserDAO user_dao;
		ArrayList<Chip> selected_chips = new ArrayList<Chip>();
		HashMap<String, String> user_selected_chips = new HashMap<String, String>();
		try {
			chip_dao = new MySQLChipDAO();
			
			//Si existen chips con el atributo thread == null
			if(chip_dao.getThreads().size() > 0){
				//Se recolectan en un arraylist los chips con thread == null
				selected_chips = chip_dao.getThreads();
				
				//Objeto MySQLUserDAO para acceder a los usuarios de la BD
				user_dao = new MySQLUserDAO();
				
				//Se recogen en un HashMap todos los nombres de usuario de usuarios que han creado un topic (chip con thread == null)
				for(Chip chip_aux:selected_chips){
					try{
						if(!user_selected_chips.containsKey(Integer.toString(chip_aux.getUser()))){
							User user_aux = null;
							user_aux = user_dao.findById(chip_aux.getUser());
							if(user_aux != null){
								user_selected_chips.put(Integer.toString(chip_aux.getUser()), user_aux.getUsername());
							}else{
								user_selected_chips.put(Integer.toString(chip_aux.getUser()), "Usuario no Encontrado");
							}
						}
					}catch(Exception e){
						if(!user_selected_chips.containsKey(Integer.toString(chip_aux.getUser()))){
							user_selected_chips.put(Integer.toString(chip_aux.getUser()),"Problema de Acceso Tabla de Usuarios");
						}
					}
				}
			}else{//Si no existen Chips, se añade un chip con id -1
				selected_chips.add(new Chip());
			}	
		} catch (Exception e) {//Si falla la conexion con la base de datos, añade un chip con id -2.
			Chip a = new Chip();
			a.setId(-2);
			selected_chips.add(a);
		}
		
		request.setAttribute(USER_TOPICS_PARAM, user_selected_chips);//Se añade un hashmap con la relacion k=idUser/v=userName
		request.setAttribute(TOPICS_PARAM, selected_chips);//Se añade un arraylist con todos los chips con thread == null a la peticion
		request.getRequestDispatcher(NEXT_PAGE_ATTR).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
