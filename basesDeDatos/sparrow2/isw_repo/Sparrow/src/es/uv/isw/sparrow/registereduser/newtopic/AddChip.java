package es.uv.isw.sparrow.registereduser.newtopic;
 
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uv.isw.sparrow.bean.Chip;
import es.uv.isw.sparrow.bean.UserBean;
import es.uv.isw.sparrow.dao.MySQLChipDAO;
 
/**
 * Servlet implementation class addChip
 */
@WebServlet("/AddChip")
public class AddChip extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String USER_ATTR = "userbean";
    private static final String TAG_ATTR = "tag";
    private static final String TEXT_PARAM = "texto";
    private static final String NEXT_PAGE = "/mainPage";
    private MySQLChipDAO cdao;
 
    /**
     * Default constructor. 
     */
    public AddChip() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        cdao = new MySQLChipDAO();
        
        //Variables
        String tag = "";
        String text= request.getParameter(TEXT_PARAM);
        int thread=-1;
        UserBean usuario=(UserBean)request.getSession().getAttribute(USER_ATTR);
        
        tag =(String)request.getParameter(TAG_ATTR);
        
        Chip newChip = new Chip();
        newChip.setUser(usuario.getId());
        newChip.setTag(tag);
        newChip.setThread(thread);
        newChip.setText(text);
        
        try {
			cdao.insert(newChip);
		} catch (SQLException e) {
			System.out.println("No se ha podido acceder a la base de datos");
			e.printStackTrace();
		}
        
        
        request.getRequestDispatcher(NEXT_PAGE).forward(request, response);
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
 
}
