package es.uv.isw.sparrow.registereduser.showbytag;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uv.isw.sparrow.bean.Chip;
import es.uv.isw.sparrow.bean.User;
import es.uv.isw.sparrow.dao.*;

/**
 * Servlet implementation class ByTag
 */
@WebServlet("/bytag")
public class ChipsByTag extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG = "tag";
	private ArrayList<Chip> chipsbytag = new ArrayList<Chip>();
	private String tag = "";

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChipsByTag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String t= request.getParameter(TAG);
		if (t == null) {
			request.getRequestDispatcher("/chipsByTag.jsp").forward(request, response);
		}else{
			tag = t;
			MySQLChipDAO chips = new MySQLChipDAO(); 
			try {				
				chipsbytag= chips.findByTag(tag);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("chipsbytag", chipsbytag);
			request.setAttribute("tag", tag);
			request.getRequestDispatcher("/chipsFound.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
