
package servidorEstadoTrafico;

//Java
import java.io.*;
import java.lang.*;
import java.util.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
* Se encarga de encapsular la el acceso a la tabla tramo de la base de datos
* @author    <a href="mailto:Daniel.Bolanos@uam.es">Daniel Bolanos Alonso</a>
* @version   1.0
*/
public class DBTramo {
   
   Connection m_conexion;
   Statement m_statement;
   
   /**
    * Constructor de la clase
    * @param baseDatos  objeto que representa la base de datos
    * @throws SQLException   en caso de error al realizar la conexion
    */
   public DBTramo(DBBaseDatos baseDatos) throws SQLException {
      
      this.m_conexion = baseDatos.obtenerConexion();
      this.m_statement = this.m_conexion.createStatement();
   }
    
   /**
    * Almacena un objeto Tramo en la tabla tramo
    * @param registro        objeto <code>Registro</code> al que pertenece el objeto tramo
    * @param tramo           objeto tramo a insertar
    * @throws SQLException   en caso de error al ejecutar la consulta SQL
    */
   public void almacenarTramo(Registro registro, Tramo tramo) throws SQLException {
   
      String strSentencia;
      strSentencia = "INSERT INTO tramo(kmInicio,kmFin,carriles,carrilesCortados,estado,accidentes,registro) VALUES (" + 
         tramo.obtenerKMInicio() + "," +
         tramo.obtenerKMFin() + "," +
         tramo.obtenerCarriles() + "," +
         tramo.obtenerCarrilesCortados() + ",\"" +
         tramo.obtenerEstado() + "\",\"" +
         tramo.obtenerAccidentes() + "\"," +
         registro.obtenerId() + ")";
                                                            
      this.m_statement.executeUpdate(strSentencia);
   }    
      
   /**
    * Devuelve una sentencia SQL para obtener los tramos con un determinado estado del trafico asociados a un registro
    * @param registro   registro sobre el cual efectuar la consulta    
    * @return           consulta SQL construida en formato texto
    */
   public String obtenerConsultaTramos(Registro registro) {
      
      String strSentencia;
      strSentencia = "SELECT * FROM tramo WHERE tramo.registro = " + registro.obtenerId() + ")"; 
         
      return strSentencia;     
   }  
           
   /**
    * Obtiene los tramos de un registro y los almacena en el objeto registro.
    * @param registro        registro
    * @throws SQLException   en caso de error al ejecutar la consulta SQL sobre la base de datos
    */
   public void obtenerTramos(Registro registro) throws SQLException {
              
      String strSentencia = obtenerConsultaTramos(registro);
      
      // ejecucion de la sentencia                                                      
      ResultSet resultset = this.m_statement.executeQuery(strSentencia);

      while(resultset.next()) {
         
         int iId = resultset.getInt("id");
         String strKMInicio = resultset.getString("kmInicio");
         String strKMFin = resultset.getString("kmFin");
         String strCarriles = resultset.getString("carriles");
         String strCarrilesCortados = resultset.getString("carrilesCortados");
         String strEstado = resultset.getString("estado");
         String strAccidentes = resultset.getString("accidentes");
         Tramo tramo = new Tramo(iId,strKMInicio,strKMFin,strCarriles,strCarrilesCortados,strEstado,strAccidentes);
         registro.anadirTramo(tramo);     
      } 
   
      resultset.close();    
         
      return;                     
   }       
      
   /**
    * Libera recursos utilizados por la clase
    * @throws SQLException   en caso de error al cerrar la consulta con la base de datos
    */
   public void liberar() throws SQLException {
        this.m_statement.close();
   }
}