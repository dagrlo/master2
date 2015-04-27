
package servidorEstadoTrafico;

//Java
import java.lang.*;

/**
* Excepcion que comunica que la informacion asociada a un objeto <code>Tramo</code> tiene un formato incorrecto
* @author    <a href="mailto:Daniel.Bolanos@uam.es">Daniel Bolanos Alonso</a>
* @version   1.0
*/
public class TramoMalFormadoException extends Exception {
	
	/**
	 * Mensaje descriptivo sobre el problema de formato encontrado
	 */
	String m_strMensaje;
		
   /**
    * Constructor de la clase
    * @param strMensaje   Mensaje descriptivo sobre el problema de formato encontrado 
    */ 
	public TramoMalFormadoException(String strMensaje) {
		this.m_strMensaje = strMensaje;
	}
	
   /**
    * Constructor de la clase
    * @return   Mensaje descriptivo sobre el problema de formato encontrado 
    */   
	public String toString() {
		return this.m_strMensaje;
	}
}