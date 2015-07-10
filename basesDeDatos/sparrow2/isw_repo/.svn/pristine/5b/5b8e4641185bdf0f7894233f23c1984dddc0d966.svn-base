package es.uv.isw.sparrow.registereduser.reply;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uv.isw.sparrow.bean.Chip;
import es.uv.isw.sparrow.dao.ChipDAO;
import es.uv.isw.sparrow.dao.MySQLChipDAO;

/**
 * Servlet implementation class ReplyFinal
 */
@WebServlet("/Reply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NEXT_PAGE_PARAM = "/mainPage";
	private static final String MESSAGE_ATTR = "message";
	private static final String USER_ID = "userId";
	//private static final String USER_NAME = "userName";
	private ChipDAO cdao;
	//private ArrayList<Chip> chips;

	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		cdao = new MySQLChipDAO();
		//chips = new ArrayList<Chip>();

		String tag = "";
		String message_error = "";

		// recupero el atributo thread que lo ingrese la session en el replyTool.java
		int thread = (int) request.getSession().getAttribute("thread");
		
		// selecciono el atributo username de la sesion
		int user = (int) request.getSession().getAttribute(USER_ID);

		// recojo el mensaje del formulario
		String message = request.getParameter(MESSAGE_ATTR);

		// selecciono el tag del texto
		StringTokenizer tokenizer = new StringTokenizer(message);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if (token.startsWith("#")) {
				tag = token;
			}
		}

		System.out.println("el valor del tag:" + tag);
		System.out.println("este es el mensaje completo:" + message);
		System.out.println("este es el valor del thread:" + thread);
		System.out.println("este es el valor del user:" + user);

		// creo un nuevo chip con los valores obtenidos de session y parametros del formulario
		Chip newChip = new Chip(tag, message, thread, user);
		try {
			cdao.insert(newChip);
		} catch (Exception e) {
			request.setAttribute("msg",	"Se ha producido un error interno al crear el proyecto");
			getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}
		
		
		//redirijo a "mainPage.jsp"
		request.getRequestDispatcher(NEXT_PAGE_PARAM).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
