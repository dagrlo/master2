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
import javax.servlet.http.HttpSession;

import es.uv.isw.sparrow.bean.Chip;
import es.uv.isw.sparrow.dao.ChipDAO;
import es.uv.isw.sparrow.dao.MySQLChipDAO;

/**
 * Servlet implementation class Reply
 */
@WebServlet("/ReplyTool")
public class ReplyTool extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NEXT_PAGE_PARAM = "/reply.jsp";
	private static final String CHIP_ID = "chipid";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReplyTool() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		// recupero el parametro de id del chip 
				int thread = Integer.parseInt(request.getParameter(CHIP_ID));
				System.out.println("el valor del valor del chip ID:" + thread);
				
				//lo guardo en la session para poder utilizarlo al responder el chip
				request.getSession(true).setAttribute("thread", thread);

				//se maneja desde "reply.jsp"
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
