
package servidorEstadoTrafico;

//Java
import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.Headers;

/**
* Atiende una peticin HTTP devolviendo un documento WEB (HTML/XML)como respuesta
* @author    <a href="mailto:Daniel.Bolanos@uam.es">Daniel Bolanos Alonso</a>
* @version   1.0
*/
public class HiloPeticion implements HttpHandler {

   /**
    * Vector que contiene los registros con la informacin del estado del trfico
    */
   private Vector m_vRegistros;
   /**
    * Objeto de Log
    */
   private Log m_log;
   /**
    * Nombre de la carpeta para cargar los documentos en respuesta a peticiones
    */
   private String m_strCarpetaXML;  
   /**
    * Ruta del archivo de registros 
    */
   private static String m_strArchivoRegistros;  
   /**
    * Direccion IP del servidor
    */
   private static String m_strDireccionIP;
   /**
    * Puerto de escucha del servidor
    */
   private static int m_iPuerto;    
   /**
    * Contador de peticiones atendidas
    */
   private static int m_iPeticionesAtendidas;
   /**
    * Tiempo de arranque del servidor
    */
   private static Calendar m_tiempoArranque;
   /**
    * Usuario administrador
    */
   private static String m_strUsuario;
   /**
    * Password del usuario administrador
    */
   private static String m_strPassword;   
   
   /**
    * Constructor de la clase
    * @param tiempoArranque   momento en el que el servidor fue arrancado
    * @param strDireccionIP   direccion IP del servidor
    * @param iPuerto          puerto de escucha del servidor 
    * @param log              objeto de log
    * @param strCarpetaXML    nombre de la carpeta para almacenar los documentos en respuesta a peticiones    
    * @param strUsuario       nombre de usuario para la detencion del servidor
    * @param strPassword      password para la detencion del servidor 
    */
   public HiloPeticion(Calendar tiempoArranque, String strDireccionIP, int iPuerto, Log log, String strCarpetaXML, String strArchivoRegistros, String strUsuario, String strPassword) {      
     
      HiloPeticion.m_tiempoArranque = tiempoArranque;
      HiloPeticion.m_strDireccionIP = strDireccionIP;
      HiloPeticion.m_iPuerto = iPuerto;
      HiloPeticion.m_strUsuario = strUsuario;
      HiloPeticion.m_strPassword = strPassword;
      this.m_log = log;   
      this.m_strCarpetaXML = strCarpetaXML; 
      this.m_strArchivoRegistros = strArchivoRegistros;
   }     
   
   /**
    * Devuelve un documento HTML con la respuesta en caso de error
    * @param strMensaje   mensaje de error
    * @return             documento HTML con un mensaje de error en forma de cadena de caracteres
    */
   public static String construirPaginaHtmlMensaje(String strMensaje) {
      
      StringBuffer outputBuffer = new StringBuffer();
      outputBuffer.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
      outputBuffer.append("<HTML><HEAD><TITLE>Mensaje</TITLE>");
      outputBuffer.append("</HEAD>");
      outputBuffer.append("<BODY>");
      outputBuffer.append("<font face=\"Verdana\" size=3><b>" + strMensaje + "</b></font>");
      outputBuffer.append("</BODY>");
      outputBuffer.append("</HTML>");
        
      return outputBuffer.toString();
   }     
      
   /**
    * Devuelve un html mostrando informacion del servidor
    * @return   documento HTML con informacion sobre el servidor
    */
   public static String construirPaginaHtmlInformacion() {
      
      String strLocalizacionRed;
      strLocalizacionRed = HiloPeticion.m_strDireccionIP + ":" + HiloPeticion.m_iPuerto;
      
      String strFecha = HiloPeticion.m_tiempoArranque.get(Calendar.DAY_OF_MONTH) + "/" + (HiloPeticion.m_tiempoArranque.get(Calendar.MONTH)+1) + "/" + (HiloPeticion.m_tiempoArranque.get(Calendar.YEAR));
      String strHora = HiloPeticion.m_tiempoArranque.get(Calendar.HOUR_OF_DAY) + ":" + HiloPeticion.m_tiempoArranque.get(Calendar.MINUTE) + ":" + HiloPeticion.m_tiempoArranque.get(Calendar.SECOND);      
      
      StringBuffer outputBuffer = new StringBuffer();      
      outputBuffer.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
      outputBuffer.append("<html>");
      outputBuffer.append("<head>");
      outputBuffer.append("<title>Informacion</title>");
      outputBuffer.append("</head>");
      outputBuffer.append("<body>");
      outputBuffer.append("<p>");
      outputBuffer.append("<font face=\"Verdana\" size=3><b>Informacion del servidor</b></font>");
      outputBuffer.append("</p>");   
      outputBuffer.append("<p>");
      outputBuffer.append("<font face=\"Verdana\" size=3><b>1. Peticiones disponibles</b></font>");
      outputBuffer.append("</p>"); 
      outputBuffer.append("<table id=\"peticiones\" border=\"1\" bordercolor=\"black\" celpadding=\"3\" cellspacing=\"0\">");
      outputBuffer.append("<tr>");
      outputBuffer.append("<th bgcolor=\"#99CCFF\">Formato</th>");
      outputBuffer.append("<th bgcolor=\"#99CCFF\">Descripcion</th>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><a id=\"tramosMasTrafico\" href=\"http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=tramosMasTrafico\"><font face=\"Verdana\" size=2>http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=tramosMasTrafico</font></a></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2>Informacion sobre los tramos de carretera con mas trafico (trafico denso)</font></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><a id=\"tramosMenosTrafico\" href=\"http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=tramosMenosTrafico\"><font face=\"Verdana\" size=2>http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=tramosMenosTrafico</font></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2>Informacion sobre los tramos de carretera con menos trafico (trafico fluido)</font></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><a id=\"carrilesCortados\" href=\"http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=carrilesCortados\"><font face=\"Verdana\" size=2>http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=carrilesCortados</font></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2>Informacion sobre los tramos de carretera que presentan carriles cortados</font></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><a id=\"obras\" href=\"http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=obras\"><font face=\"Verdana\" size=2>http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=obras</font></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2>Lista de carreteras con obras</font></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><a id=\"accidentes\" href=\"http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=accidentes\"><font face=\"Verdana\" size=2>http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=accidentes</font></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2>Informacion sobre los tramos de carretera que presentan accidentes</font></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><a id=\"carretera\" href=\"http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=carretera&amp;carretera=M-40\"><font face=\"Verdana\" size=2>http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=carretera&amp;carretera=M-40</font></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2>Informacion completa sobre una carretara (M-40 en el ejemplo)</font></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><a id=\"clima\" href=\"http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=clima&amp;clima=Favorable\"><font face=\"Verdana\" size=2>http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=clima&amp;clima=Favorable</font></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2>Lista de carreteras con un determinado clima (Favorable en el ejmplo)</font></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><a id=\"detenerServidor\" href=\"http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=detenerServidor\"><font face=\"Verdana\" size=2>http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=detenerServidor</font></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2>Parada remota del servidor</font></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><a id=\"informacion\" href=\"http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=informacion\"><font face=\"Verdana\" size=2>http://" + strLocalizacionRed + "/servidorEstadoTrafico/?peticion=informacion</font></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2>Informacion del servidor</font></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("</table>");    
      outputBuffer.append("<p>");
      outputBuffer.append("<font face=\"Verdana\" size=3><b>2. Estado</b></font>");
      outputBuffer.append("</p>"); 
      outputBuffer.append("<table id=\"estado\" cellpadding=\"2\">");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2><b>Fecha de arranque:</b></font><br></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2><b>" + strFecha + "</b></font><br></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2><b>Hora de arranque:</b></font><br></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2><b>" + strHora + "</b></font><br></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2><b>Peticiones atendidas:</b></font><br></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2><b>" + HiloPeticion.m_iPeticionesAtendidas + "</b></font><br></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("</table>");          
      outputBuffer.append("<p>");
      outputBuffer.append("<font face=\"Verdana\" size=3><b>3. General</b></font>");
      outputBuffer.append("</p>");   
      outputBuffer.append("<table id=\"general\" cellpadding=\"2\">");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2><b>Autor:</b></font><br></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2><b>Daniel Bolanos</b></font><br></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2><b>Version:</b></font><br></td>");
      outputBuffer.append("<td><font face=\"Verdana\" size=2><b>1.0</b></font><br></td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("</table>");
      outputBuffer.append("</body>");
      outputBuffer.append("</html>");  
             
      return outputBuffer.toString();
   }          
      
   /**
    * Devuelve un documento HTML con el formulario de autenticacion
    * @return   documento HTML construido con el formulario de autenticacion
    */
   public static String construirPaginaHtmlFormularioAutenticacion() {
      
      StringBuffer outputBuffer = new StringBuffer();      
      
      outputBuffer.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
      outputBuffer.append("<html>");
      outputBuffer.append("<head>");
      outputBuffer.append("<title>Formulario de autenticacion</title>");
      outputBuffer.append("</head>");
      outputBuffer.append("<body>");
      outputBuffer.append("<p>");
      outputBuffer.append("<font face=\"Verdana\" size=3><b>Solo usuarios autorizados pueden detener el sistema</b></font>");
      outputBuffer.append("</p>");   
      outputBuffer.append("<form name=\"autenticacion\" action=\"./\" method=\"GET\">");
      outputBuffer.append("<table border=\"1\" bordercolor=\"black\" cellspacing=\"0\">");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td align=\"right\" bgcolor=\"#AACCFF\">");
      outputBuffer.append("<font face=\"Verdana\" size=2>Usuario:<font> <input name=usuario><br>");
      outputBuffer.append("</td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td align=\"right\" bgcolor=\"#AACCFF\">");
      outputBuffer.append("<font face=\"Verdana\" size=2>Password:<font> <input type=\"password\" name=password><br>");
      outputBuffer.append("</td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("<tr>");
      outputBuffer.append("<td align=\"center\">");
      outputBuffer.append("<input type=submit value=\"enviar datos\" name=\"enviar datos\">");
      outputBuffer.append("</td>");
      outputBuffer.append("</tr>");
      outputBuffer.append("</table>");
      outputBuffer.append("</form>");
      outputBuffer.append("</body>");
      outputBuffer.append("</html>");
      
      return outputBuffer.toString();      
   }         
    
   /**
    * A partir de una peticin HTTP construye un documento de respuesta y lo envia al cliente
    * @param intercambio             objeto que representa el intercambio de informacion entre entidades
    * @param strConsulta             peticin HTTP aprocesar
    */
   public void construirRespuesta(HttpExchange intercambio, String strConsulta) { 
    
      Document documento=null;
      
      GeneradorXML generadorXML = new GeneradorXML(this.m_log); 
               
      //Vemos cual es el tipo de peticion que ha llegado
      if (strConsulta.compareTo("peticion=tramosMasTrafico") == 0) {    

         //Se construye el XML con la respuesta
         documento = generadorXML.construirXMLTramosMasTrafico(m_vRegistros);
         this.enviarDocumentoXml(intercambio,documento);
         this.almacenarDocumentoXml(documento);
      
      } else if (strConsulta.compareTo("peticion=tramosMenosTrafico") == 0) {    
      
         //Se construye el XML con la respuesta
         documento = generadorXML.construirXMLTramosMenosTrafico(m_vRegistros);
         this.enviarDocumentoXml(intercambio,documento);
         this.almacenarDocumentoXml(documento);
      
      } else if (strConsulta.compareTo("peticion=carrilesCortados") == 0) {    
      
         //Se construye el XML con la respuesta
         documento = generadorXML.construirXMLCarrilesCortados(m_vRegistros);
         this.enviarDocumentoXml(intercambio,documento);
         this.almacenarDocumentoXml(documento);
         
      } else if (strConsulta.compareTo("peticion=obras") == 0) {    
      
         //Se construye el XML con la respuesta
         documento = generadorXML.construirXMLCarreterasObras(m_vRegistros);
         this.enviarDocumentoXml(intercambio,documento);
         this.almacenarDocumentoXml(documento);
      
      } else if (strConsulta.compareTo("peticion=accidentes") == 0) {          
      
         //Se construye el XML con la respuesta
         documento = generadorXML.construirXMLCarreterasAccidentes(m_vRegistros);        
         this.enviarDocumentoXml(intercambio,documento);
         this.almacenarDocumentoXml(documento);
                  
      } else if (strConsulta.startsWith("peticion=carretera&carretera=") == true) {
                 	
         //Extraccion del valor de la carretera y verificacion
         String strCarretera = strConsulta.substring(29);     
         if  ((strCarretera.indexOf('&') != -1) || (strCarretera.indexOf('=') != -1)) {
            //Se envia una pagina de error
            String strPaginaHtml = this.construirPaginaHtmlMensaje("Error: formato de peticion incorrecto.");
            this.enviarDocumentoHtml(intercambio,strPaginaHtml);                           
         } else {
            //Se construye el XML con la respuesta
            documento = generadorXML.construirXMLCarretera(m_vRegistros,strCarretera);        
            this.enviarDocumentoXml(intercambio,documento);
            this.almacenarDocumentoXml(documento);                        
         }                     
         
      } else if (strConsulta.startsWith("peticion=clima&clima=")) {
                  
         //Extracion del valor del clima y verificacion
         String strClima = strConsulta.substring(21);  
         if  ((strClima.indexOf('&') != -1) || (strClima.indexOf('=') != -1)) {
            //Se envia una pagina de error
            String strPaginaHtml = this.construirPaginaHtmlMensaje("Error: formato de peticion incorrecto.");
            this.enviarDocumentoHtml(intercambio,strPaginaHtml);                                          
         } else {
            //Se construye el XML con la respuesta
            documento = generadorXML.construirXMLClima(m_vRegistros,strClima);                 
            this.enviarDocumentoXml(intercambio,documento);
            this.almacenarDocumentoXml(documento);
         }     
         
      } else if (strConsulta.compareTo("peticion=detenerServidor") == 0) {          
      
         //Se envia el formulario de autenticacion previo a la detencion
         String strPaginaHtml = this.construirPaginaHtmlFormularioAutenticacion();
         this.enviarDocumentoHtml(intercambio,strPaginaHtml);                           
         
      } else if (strConsulta.compareTo("usuario=" + HiloPeticion.m_strUsuario + "&password=" + HiloPeticion.m_strPassword) == 0) {          
      
         //Se comunica al servidor que debe detenerse
         ServidorXML.detener();
         String strPaginaHtml = this.construirPaginaHtmlMensaje("Servidor detenido con exito.");
         this.enviarDocumentoHtml(intercambio,strPaginaHtml);                           
         
      } else if (strConsulta.startsWith("usuario=") == true) {                
      
         //Autenticacion fallida: se envia el formulario de autenticacion previo a la detencion         
         String strPaginaHtml = this.construirPaginaHtmlFormularioAutenticacion();
         this.enviarDocumentoHtml(intercambio,strPaginaHtml);                           
         
      } else if (strConsulta.compareTo("peticion=informacion") == 0) {          
      
         //Se comunica al servidor que debe detenerse
         String strPaginaHtml = this.construirPaginaHtmlInformacion();
         this.enviarDocumentoHtml(intercambio,strPaginaHtml);                           
         
      } else {     

         //Se envia una pagina de error
         String strPaginaHtml = this.construirPaginaHtmlMensaje("Error: formato de peticion incorrecto.");
         this.enviarDocumentoHtml(intercambio,strPaginaHtml);               
      }  
   }   
      
   /**
    * Envia un documento XML como respuesta a la peticion HTTP
    * @param intercambio   objeto que representa el intercambio de informacion entre entidades
    * @param documento     documento XML a enviar
    */
   private void enviarDocumentoXml(HttpExchange intercambio, Document documento) {
      
      try {
         
         Headers headers = intercambio.getResponseHeaders();
         headers.add("Content-Type","text/xml");
         intercambio.sendResponseHeaders(200, 0);
         
         OutputStream os = intercambio.getResponseBody();
         TransformerFactory tranFactory = TransformerFactory.newInstance();
         Transformer aTransformer = tranFactory.newTransformer();
         Source src = new DOMSource(documento);
         Result dest = new StreamResult(os);
         aTransformer.transform(src, dest); 
         os.close();
         
      } catch (IOException e) {   
      
         this.m_log.nuevoMensaje("Excepcin al enviar el documento XML de respuesta, run");                
            
      } catch (TransformerException e) {   
      
         this.m_log.nuevoMensaje("Excepcion al enviar el documento XML de respuesta, run");                
      }                    
   }  
      
   /**
    * Envia un documento HTML como respuesta a la peticion HTTP
    * @param intercambio   objeto que representa el intercambio de informacion entre entidades
    * @param strHtml       documento a enviar
    */
   private void enviarDocumentoHtml(HttpExchange intercambio, String strHtml) {     
      
      try {
      
         Headers headers = intercambio.getResponseHeaders();
         headers.add("Content-Type","text/html");
         intercambio.sendResponseHeaders(200, 0);
         
         OutputStream os = intercambio.getResponseBody();
         os.write(strHtml.getBytes());
         os.close();       
            
      } catch (IOException e) {   
      
         this.m_log.nuevoMensaje("Excepcion al enviar el documento HTML de respuesta, run");           
      }
   }  
      
   /**
    * Almacena un documento XML en la carpeta de peticiones
    * @param documento    documento a almacenar
    */
   private void almacenarDocumentoXml(Document documento) {
      
      try {

         //Guardamos el documento en la carpeta de peticiones      
         TransformerFactory tranFactory = TransformerFactory.newInstance();
         Transformer aTransformer = tranFactory.newTransformer();   
         Source src = new DOMSource(documento);    
         new File(this.m_strCarpetaXML).mkdir();
         Result dest = new StreamResult(new File(this.m_strCarpetaXML + "peticion" + this.m_iPeticionesAtendidas + ".xml"));
         aTransformer.transform(src, dest);        
        
      } catch (TransformerException e) {   
      
         this.m_log.nuevoMensaje("Excepcion al almacenar el XML de respuesta, construirRespuesta");         
      }       
   }
      
   /**
   * Procesa una peticion HTTP
   * @param intercambio    objeto que representa el intercambio de informacion entre entidades
   * @throws IOException   en caso de error de entrada/salida durante el procesado de la peticion HTTP
   */
   public void handle(HttpExchange intercambio) throws IOException {   

      ++HiloPeticion.m_iPeticionesAtendidas;
      InputStream is = intercambio.getRequestBody();     
      URI uri = intercambio.getRequestURI();
      String strConsulta = uri.getQuery();      
      
      try {

         //Lectura de los registros
         LectorRegistros lector = new LectorRegistros(this.m_strArchivoRegistros); 
         this.m_vRegistros = lector.leerRegistros();
         
      } catch(RegistroMalFormadoException e) {
         
         String strPaginaHtml = this.construirPaginaHtmlMensaje("Error: formato de archivo de registros incorrecto.");
         this.enviarDocumentoHtml(intercambio,strPaginaHtml);
         return;
      
      } catch(TramoMalFormadoException e) {
         
         String strPaginaHtml = this.construirPaginaHtmlMensaje("Error: formato de archivo de registros incorrecto.");
         this.enviarDocumentoHtml(intercambio,strPaginaHtml);
         return;
      }      

      //Almacenamiento de la consulta en el archivo de log
      this.m_log.nuevoMensaje(strConsulta);
      //Construccion y envio de la respuesta
      this.construirRespuesta(intercambio,strConsulta);  
      
   }
} 
