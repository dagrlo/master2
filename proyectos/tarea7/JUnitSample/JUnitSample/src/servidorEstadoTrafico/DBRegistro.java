
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
* Se encarga de encapsular la el acceso a la tabla registro de la base de datos
* @author    <a href="mailto:Daniel.Bolanos@uam.es">Daniel Bolanos Alonso</a>
* @version   1.0
*/
public class DBRegistro {
   
   /**
    * Objecto que representa la conexion con la base de datos
    */
   Connection m_conexion;
   /**
    * Objeto que representa una consulta a la base de datos
    */
   Statement m_statement;
   /**
    * Objeto para el acceso a la tabla tramo de la base de datos
    */
   DBTramo m_dbTramo;
   
   /**
    * Constructor de la clase
    * @param baseDatos       objeto que representa la base de datos
    * @param dbTramo         objeto que representa la tabla tramo
    * @throws SQLException   en caso de error al realizar la conexion
    */
   public DBRegistro(DBBaseDatos baseDatos, DBTramo dbTramo) throws SQLException {
        
      this.m_conexion = baseDatos.obtenerConexion();
      this.m_dbTramo = dbTramo;
      this.m_statement = this.m_conexion.createStatement();             
   }
    
   /**
    * Almacena un objeto Registro en la tabla registro
    * @param registro                       objeto a almacenar en la tabla de registros
    * @throws SQLException                  en caso de error al conectar
    * @throws RegistroMalFormadoException   en caso de que el formato del objecto sea incorrecto
    */
   public void almacenarRegistro(Registro registro) throws SQLException,RegistroMalFormadoException {
              
      // conversion de la fecha
      String strFecha = convertirFechaFormatoBD(registro.obtenerFecha());

      String strSentencia;
      strSentencia = "INSERT INTO registro(carretera,hora,fecha,clima,obras) VALUES (\"" +
                                                       registro.obtenerCarretera() + "\",\"" +
                                                       registro.obtenerHora() + "\",\"" +
                                                       strFecha + "\",\"" +
                                                       registro.obtenerClima() + "\",\"" +
                                                       registro.obtenerObras() + "\")";
      
      // ejecucion de la sentencia                                                      
      this.m_statement.executeUpdate(strSentencia);
      
      // obtencion de la clave primaria
      ResultSet resultset = this.m_statement.getGeneratedKeys();                  
      int columns = resultset.getMetaData().getColumnCount();
      resultset.next();
      
      // obtencion de la clave primaria asociada al registro insertado (valor de la primera columna)
      int iId = resultset.getInt(1);
      registro.modificarId(iId);
      
      // almacenamiento de los tramos  en la base de datos
      Vector vTramos = registro.obtenerTramos();
      for(Enumeration e = vTramos.elements() ; e.hasMoreElements() ; ) {
         Tramo tramo = (Tramo)e.nextElement();
         m_dbTramo.almacenarTramo(registro,tramo);    
      }
   
      resultset.close();                         
   }  
      
   /**
    * Devuelve una sentencia SQL para obtener los registros con tramos con un determinado estado del trafico
    * @param strEstado   estado del trafico   
    * @return            consulta SQL en formato texto
    */
   public String obtenerConsultaTramosTrafico(String strEstado) {
      
      String strSentencia;
      strSentencia = "SELECT registro.carretera,registro.hora,registro.fecha,registro.clima,registro.obras,tramo.id,tramo.kmInicio,tramo.kmFin,tramo.carriles,tramo.carrilesCortados,tramo.estado,tramo.accidentes,tramo.registro FROM registro,tramo WHERE tramo.estado = \"" + strEstado + "\" and registro.id = tramo.registro ORDER BY tramo.registro"; 
         
      return strSentencia;     
   }  
           
   /**
    * Devuelve una sentencia SQL para obtener los registros con tramos con al menos un carril cortado
    * @return   consulta SQL en formato texto
    */
   public String obtenerConsultaTramosCarrilesCortados() {
      
      String strSentencia;
      strSentencia = "SELECT registro.carretera,registro.hora,registro.fecha,registro.clima,registro.obras,tramo.id,tramo.kmInicio,tramo.kmFin,tramo.carriles,tramo.carrilesCortados,tramo.estado,tramo.accidentes,tramo.registro FROM registro,tramo WHERE tramo.carrilesCortados > 0 and registro.id = tramo.registro ORDER BY tramo.registro"; 
         
      return strSentencia;     
   }  
           
   /**
    * Obtiene los registros con tramos con un determinado estado del trafico (retenciones, trafico fluido, etc)
    * @param strEstado       estado
    * @return vRegistros     vector de registros en el que cada registro contiene unicamente los tramos con dicho estado del trafico
    * @throws SQLException   en caso de error al ejecutar la consulta SQL sobre la base de datos 
    */
   public Vector<Registro> obtenerRegistrosTramosTrafico(String strEstado) throws SQLException {
              
      String strSentencia = obtenerConsultaTramosTrafico(strEstado);
      
      // ejecucion de la sentencia                                                      
      ResultSet resultset = this.m_statement.executeQuery(strSentencia);

      Vector<Registro> vRegistros = new Vector<Registro>();
      int iLastId = -1;
      Registro lastRegistro = null;
      while(resultset.next()) {
         
         int iId = resultset.getInt("id");
         String strKMInicio = resultset.getString("kmInicio");
         String strKMFin = resultset.getString("kmFin");
         String strCarriles = resultset.getString("carriles");
         String strCarrilesCortados = resultset.getString("carrilesCortados");
         String strAccidentes = resultset.getString("accidentes");         
         int iRegistro = resultset.getInt("tramo.registro");
         Tramo tramo = new Tramo(iId,strKMInicio,strKMFin,strCarriles,strCarrilesCortados,strEstado,strAccidentes);
         // comprobar si se trata de otro tramo del anterior registro o de uno diferente
         if (iRegistro == iLastId) {
            lastRegistro.anadirTramo(tramo);
         } else {
            String strCarretera = resultset.getString("registro.carretera");
            String strHora = resultset.getString("registro.hora");
            String strFecha = resultset.getString("registro.fecha");
            String strClima = resultset.getString("registro.clima");
            String strObras = resultset.getString("registro.obras");
            Registro registro = new Registro(iRegistro,strCarretera,strHora,strFecha,strClima,strObras);
            registro.anadirTramo(tramo);            
            vRegistros.add(registro);
            lastRegistro = registro;
            iLastId = iRegistro;
         }         
      } 
   
      resultset.close();         
      
      return vRegistros;                     
   }     
    
    
   /**
    * Obtiene los registros con tramos con al menos un carril cortado
    * @return vRegistros     vector de registros en el que cada registro contiene unicamente los tramos con al menos un carril cortado
    * @throws SQLException   en caso de error al ejecutar la consulta SQL sobre la base de datos
    */
   public Vector<Registro> obtenerRegistrosTramosCarrilesCortados() throws SQLException {
              
      String strSentencia = obtenerConsultaTramosCarrilesCortados();
      
      // ejecucion de la sentencia                                                      
      ResultSet resultset = this.m_statement.executeQuery(strSentencia);

      Vector<Registro> vRegistros = new Vector<Registro>();
      int iLastId = -1;
      Registro lastRegistro = null;
      while(resultset.next()) {
         
         int iId = resultset.getInt("id");
         String strKMInicio = resultset.getString("kmInicio");
         String strKMFin = resultset.getString("kmFin");
         String strCarriles = resultset.getString("carriles");
         String strCarrilesCortados = resultset.getString("carrilesCortados");
         String strEstado = resultset.getString("estado");
         String strAccidentes = resultset.getString("accidentes");         
         int iRegistro = resultset.getInt("tramo.registro");
         Tramo tramo = new Tramo(iId,strKMInicio,strKMFin,strCarriles,strCarrilesCortados,strEstado,strAccidentes);
         // comprobar si se trata de otro tramo del anterior registro o de uno diferente
         if (iRegistro == iLastId) {
            lastRegistro.anadirTramo(tramo);
         } else {
            String strCarretera = resultset.getString("registro.carretera");
            String strHora = resultset.getString("registro.hora");
            String strFecha = resultset.getString("registro.fecha");
            String strClima = resultset.getString("registro.clima");
            String strObras = resultset.getString("registro.obras");
            Registro registro = new Registro(iRegistro,strCarretera,strHora,strFecha,strClima,strObras);
            registro.anadirTramo(tramo);            
            vRegistros.add(registro);
            lastRegistro = registro;
            iLastId = iRegistro;
         }         
      } 
   
      resultset.close();         
      
      return vRegistros;                     
   }  
      
   /**
    * Libera recursos utilizados por la clase
    * @throws SQLException   en caso de error al cerrar la consulta con la base de datos
    */
   public void liberar() throws SQLException {
        this.m_statement.close();
   }
   
   /**
    * Convierte una fecha del formato DD/MM/AAAA al formato AAAA-MM-DD que es el formato de la base de datos
    * @param strFecha                       fecha a convertir
    * @return                               cadena de texto con la fecha en el nuevo formato
    * @throws RegistroMalFormadoException   en caso de que el registro tenga un formato incorrecto
    */
   public String convertirFechaFormatoBD(String strFecha) throws RegistroMalFormadoException {
      
      String strDia,strMes,strAno;
      
      //obtencion de la fecha en dia/mes/ano
      StringTokenizer st = new StringTokenizer(strFecha,"/");
      if (st.hasMoreTokens()) {
         strDia = st.nextToken();
      } else {
         throw new RegistroMalFormadoException("dia de captura incorrecto.");
      }
      if (st.hasMoreTokens()) {
         strMes = st.nextToken();
      } else {
         throw new RegistroMalFormadoException("mes de captura incorrecto.");
      }
      if (st.hasMoreTokens()) {
         strAno = st.nextToken();
      } else {
         throw new RegistroMalFormadoException("ano de captura incorrecto.");
      }     
      
      String strFechaBD = strAno + "-" + strMes + "-" + strDia;         
         
      return strFechaBD;
   }   
}

            

            
 
             