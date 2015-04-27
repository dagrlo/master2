
package servidorEstadoTrafico;

//Java
import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
* Servidor HTTP que publica documentos en formato XML con informacion acerca del estado del trafico en un puerto:ip mediante la clase <code>HttpServer</code>
* @author    <a href="mailto:Daniel.Bolanos@uam.es">Daniel Bolanos Alonso</a>
* @version   1.0
*/
public class ServidorXML extends Thread {
   
   /**
    * Indica si el servidor debe terminar
    */
   private static boolean m_bTerminar;    
   /**
    * Puerto de escucha del servidor
    */
   private static int m_iPuerto;    
   /**
    * Direccion IP del servidor
    */
   private static String m_strDireccionIP;
   /**
    * Fecha de arranque del servidor
    */
   private static Calendar m_tiempoArranque;
   /**
    * Usuario administrador
    */
   private static String m_strUsuario;
   /**
    * Passowrd del usuario administrados
    */
   private static String m_strPassword; 
   /**
    * Objeto de log
    */
   private Log m_log;    
   /**
    * Nombre del archivo del que leer los registros (interfaz con el Sistema de Observacin y Registro del Trfico)
    */
   private static String m_strArchivoRegistros;
   /**
    * Nombre del archivo de log
    */
   private String m_strArchivoLog;
   /** 
    * Nombre de la carpeta para almacenar los documentos en respuesta a peticiones
    */
   private String m_strCarpetaXML;
   /**
    * Servidor
    */
   private static HttpServer m_servidor; 
  
   /**
    * Constructor de la clase
    */
   public ServidorXML() {
      
      ServidorXML.m_bTerminar = false;
      
      ResourceBundle propiedades = ResourceBundle.getBundle("config");      
      
      //Obtencion del nombre del archivo de log
      this.m_strArchivoLog = propiedades.getString("log_file");      
      //Obtencion del puerto en el que escuchar el servidor
      String strPuerto = propiedades.getString("server_portuser");  
      //Obtencion del usuario administrador
      ServidorXML.m_strUsuario = propiedades.getString("usuario_administrador");  
      //Obtencion de la password del usuario administrador
      ServidorXML.m_strPassword = propiedades.getString("password_administrador");  
      //Obtencion de la direccion IP local
      try {
         this.m_strDireccionIP = InetAddress.getLocalHost().getHostAddress();    
      }  catch(UnknownHostException e) {
         this.m_strDireccionIP = "direccionRed";
      }
      //Obtencion del nombre del archivo desde el cual se cargaran los datos
      this.m_strArchivoRegistros = propiedades.getString("data_file");      
      //Obtenemos el la carpeta donde se guardaran los XML servidos
      this.m_strCarpetaXML = propiedades.getString("xml_folder");  

      try {                  
      
         this.m_iPuerto = Integer.parseInt(strPuerto);
         
      } catch (Exception e) { 
      
         m_log.nuevoMensaje("Error al cargar la configuracion, ServidorXML");
         
         return;
      } 
               
   }    
      
   /**
    * Comunica al servidor que debe detener su ejecucion
    */
   public static void detener() {
      
      ServidorXML.m_bTerminar = true;      
   }
      
   /**
    * Arranca el servidor
    */
   public void arrancar() {
      
      //Creacion del archivo de log  
      this.m_log = new Log("ServidorXML",this.m_strArchivoLog);
      this.m_log.inicializar();
      //Obtencion de la fecha de arranque
      ServidorXML.m_tiempoArranque = Calendar.getInstance();                
         
      try {

         m_servidor = HttpServer.create(new InetSocketAddress(this.m_iPuerto),0);
         HttpContext contexto = m_servidor.createContext("/servidorEstadoTrafico/",new HiloPeticion(ServidorXML.m_tiempoArranque,this.m_strDireccionIP,this.m_iPuerto,this.m_log,this.m_strCarpetaXML,this.m_strArchivoRegistros,ServidorXML.m_strUsuario,ServidorXML.m_strPassword));
         m_servidor.setExecutor(null);
         m_servidor.start();
         System.out.println("Servidor arrancado");
         
         //Comprueba cada segundo si ha sido solicitada una parda del servidor
         while(true) {
            
            try {             
               
               Thread.sleep(100);
               
            } catch(InterruptedException e) {               
               
            }
            
            if (ServidorXML.m_bTerminar == true) {
               ServidorXML.m_servidor.stop(1);
               break;
            }            
         }
          
      } catch (IOException e) {
         
         m_log.nuevoMensaje("Error al cargar la configuracion del servidor");
         
         return;                   
      }  
         
      this.m_log.cerrar();
   }   
   
   /**
    * Main 
    * @param args   argumentos, no es necesario invocar al servidor con ningun argumento           
    */
   public static void main (String args[]) throws Exception {   
      
      System.out.println("Arrancando el servidor...");
      
      //Se crea una instancia del servidor       
      ServidorXML servidorXML = new ServidorXML();      
      
      //Se arranca el servidor
      servidorXML.arrancar();           
   }        
}
      
      

