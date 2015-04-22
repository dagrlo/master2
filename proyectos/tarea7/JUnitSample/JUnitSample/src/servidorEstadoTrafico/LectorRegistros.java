
package servidorEstadoTrafico;

//Java
import java.io.*;
import java.lang.*;
import java.util.*;

/**
* Lee los registros con informacion del estado del trafico desde un fichero 
* @author    <a href="mailto:Daniel.Bolanos@uam.es">Daniel Bolanos Alonso</a>
* @version   1.0
*/
public class LectorRegistros {
   
   /**
    * Archivo del que leer los registros
    */
   String m_strArchivo;          
   
   /**
    * Constructor de la clase
    * @param strArchivo   archivo del que leer los registros
    */
   public LectorRegistros(String strArchivo) {
      
      this.m_strArchivo = strArchivo;
   }   
   	
   /**
    * Crea un objeto de la clase colaboradora <code>Registro</code>, este metodo ha sido creado por refactorizacion
    * @param strCarretera   Nombre de la carretera
    * @param strHora        Hora de la medicion
    * @param strFecha       Fecha de la medicion
    * @param strClima       Clima
    * @param strObras       Obras
    */
   protected Registro crearRegistro(String strCarretera, String strHora, String strFecha, String strClima, String strObras) {
       	   	
      return new Registro(strCarretera,strFecha,strHora,strClima,strObras);
   }
   
   /**
    * Crea un objeto de la clase colaboradora <code>Tramo</code>, este metodo ha sido creado por refactorizacion
    * @param strKMInicio           kilometro de inicio del tramo 
    * @param strKMFin              kilometro final del tramo                
    * @param strCarriles           numero de carriles   
    * @param strCarrilesCortados   numero de carriles cortados
    * @param strEstado             estado del tramo  
    * @param strAccidentes         accidentes
    */
    protected Tramo crearTramo(String strKMInicio, String strKMFin, String strCarriles, String strCarrilesCortados, String strEstado, String strAccidentes) {
       	   	
      return new Tramo(strKMInicio,strKMFin,strCarriles,strCarrilesCortados,strEstado,strAccidentes);
   }
   
   /**
    * Lee los registros del archivo
    * @return                               vector de objetos <code>Registro</code> que contiene los registros leidos
    * @throws IOExpeption                   en caso de error de entrada/salida al leer los registros
    * @throws RegistroMalFormadoException   en caso de error de formato en la informacion de los registros
    * @throws TramoMalFormadoException      en caso de error de formato en la informacion de los tramos 
    */
   public Vector<Registro> leerRegistros() throws IOException, RegistroMalFormadoException, TramoMalFormadoException {
      
      StringTokenizer strTokenizer;
      String strRegistro;
      String strToken;
      Registro registro;
      Tramo tramo;
      Vector<Registro> vRegistros;
      
      //Creacion del objeto para acceder al fichero
      File archivo = new File(this.m_strArchivo);
     
      //Creacion del objeto para la lectura desde el archivo
      FileInputStream entrada = new FileInputStream(archivo);
     
      //Creacion del objeto para leer lineas del dichero        
      BufferedReader buffered = new BufferedReader(new InputStreamReader(entrada));
     
      //Creacion del vector para almacenar los registros
      vRegistros = new Vector<Registro>();
     
      do {       
      	
         //Lectura de un registro del archivo         
         strRegistro = buffered.readLine();
         if (strRegistro == null)
            break; 
               
         //Creacion de un objeto para extraer los elementos del String
         strTokenizer = new StringTokenizer(strRegistro,"|");
         //Se toman los elementos del String
         String strCarretera = strTokenizer.nextToken();
         String strFecha = strTokenizer.nextToken();
         String strHora = strTokenizer.nextToken();
         String strClima = strTokenizer.nextToken();
         String strObras = strTokenizer.nextToken();
         registro = crearRegistro(strCarretera,strHora,strFecha,strClima,strObras);
         	
         //Se comprueba si hay tramos         
         while (strTokenizer.hasMoreElements()) {          	
         	//Se toman los elementos del String
            String strKMInicio = strTokenizer.nextToken();
            String strKMFin = strTokenizer.nextToken();
            String strCarriles = strTokenizer.nextToken();
            String strCarrilesCortados = strTokenizer.nextToken();
            String strEstado = strTokenizer.nextToken();
            String strAccidentes = strTokenizer.nextToken();
            //Creacion de un nuevo tramo
            tramo = crearTramo(strKMInicio,strKMFin,strCarriles,strCarrilesCortados,strEstado,strAccidentes);
            tramo.comprobarFormato();           
            //Se guarda el tramo en el registro
            registro.anadirTramo(tramo);           
         }          
         registro.comprobarFormato();             
        
         //Se anade el registro al vector de registros
         vRegistros.add(registro); 
        
      } while (true);         
       
      return vRegistros;            
   }   
}
      


