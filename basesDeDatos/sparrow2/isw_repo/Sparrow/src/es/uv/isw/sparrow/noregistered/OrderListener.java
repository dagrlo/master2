package es.uv.isw.sparrow.noregistered;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import es.uv.isw.sparrow.bean.UserBean;
import es.uv.isw.sparrow.bean.UserBeanFactory;

/**
 * Application Lifecycle Listener implementation class OrderListener
 *
 */
@WebListener
public class OrderListener implements HttpSessionListener {	
	public static final String UB_ATTR = "userbean";

	/**
     * Default constructor. 
     */
    public OrderListener() {}

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
//    	ShoppingCart orders = new ShoppingCart();
		UserBean ub = UserBeanFactory.newInstance();
    	HttpSession session = arg0.getSession();
    	session.setAttribute(UB_ATTR, ub);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
    	HttpSession session = arg0.getSession();
       	session.removeAttribute(UB_ATTR);
    }	
}
