
package servidorEstadoTrafico;

//Java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* Se encarga de encapsular la comunicacion con la base de datos
* @author    <a href="mailto:Daniel.Bolanos@uam.es">Daniel Bolanos Alonso</a>
* @version   1.0
*/
public class DBBaseDatos {
   
   /**
    * URL de acceso a la base de datos
    */
   String m_strUrl;
   /**
    * Usuario de acceso a la base de datos
    */
   String m_strUsuario;
   /**
    * Password de acceso a la base de datos
    */
   String m_strPassword;
   /**
    * Objeto de conexion con la base de datos
    */
   Connection m_conexion;

   /**
    * Constructor de la clase
    * @param strUrl        URL de localizacion de la base de datos
    * @param strUsuario    usuario de acceso a la base de datos
    * @param strPassword   password de acceso a la base de datos 
    */
   public DBBaseDatos(String strUrl, String strUsuario, String strPassword) {
      
      this.m_strUrl = strUrl;
      this.m_strUsuario = strUsuario;
      this.m_strPassword = strPassword;
   }
   
   /**
    * Devuelve la conexion creada
    * @return   objeto de conexion con la base de datos
    */
   public Connection obtenerConexion() {
      
      return this.m_conexion;
   }    
    
   /**
    * Crea una conexion con la base de datos 
    * @throws SQLException             en caso de error al conectar
    * @throws ClassNotFoundException   en caso de que la clase del driver no haya sido encontrada
    */
   public void conectar() throws SQLException, ClassNotFoundException {      
    
      //Registro del driver
      Class.forName("com.mysql.jdbc.Driver");
   
      //Creacion de la conexion
      m_conexion = DriverManager.getConnection(this.m_strUrl,this.m_strUsuario,this.m_strPassword);
   }

   /**
    * Desconecta de la base de datos
    */    
   public void desconectar() {
   }    
}