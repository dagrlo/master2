
package servidorEstadoTrafico;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
* Almacenar infromacion sobre errores en un archivo de texto.
* @author    <a href="mailto:Daniel.Bolanos@uam.es">Daniel Bolanos Alonso</a>
* @version   1.0
*/
public class Log {
   
   /**
    * Nombre del archivo de log
    */
   private static String m_strArchivo;
   /**
    * Archivo de log
    */
   private static File m_archivo;
   /**
    * Objeto para escritura de datos en archivo
    */
   private static FileOutputStream m_salida;
   /**
    * Objeto para escritura
    */
   private static PrintStream m_print; 
   /**
    * Nombre de la clase que hace uso de este objeto de log
    */
   private String m_strClase;        
   
   /**
    * Constructor de la clase
    * @param strClase      nombre de la clase que hace uso de este objeto de log      
    * @param strArchivo    nombre del archivo de log
    */
   public Log(String strClase, String strArchivo) {
      
      this.m_strArchivo = strArchivo;
      this.m_strClase = "[" + strClase + "]";         
   }   
   	
   /**
    * Inicializa el archivo de log
    * @return   <code>true</code> en caso de la inicializacion se realice con exito, <code>false</code> en otro caso
    */
   public boolean inicializar() {
   	
   	//Si el archivo ya existe termina
      if (m_archivo != null) {
         System.out.println("El fichero de log ya existe.");
         return false;     
      }          
      System.out.println(m_strArchivo);
      
      try {
      
         //Se crea el fichero
         m_archivo = new File(m_strArchivo);
         
         //Se crea un objeto para la escritura en el archivo
         m_salida = new FileOutputStream(m_archivo);
         
         //Se crea un objeto para escribir cadenas de caracteres
         m_print = new PrintStream(m_salida);   
            
      } catch (IOException e) {      	
         System.out.println("[Log] Error al crear fichero de log: " + m_strArchivo);
      }          	
      	
      return true;
   }
   
   /**
    * Cierra el archivo de log
    */
   public void cerrar() {
      
      this.m_print.close();
   }   
   
   /**
    * Escribe una linea en el archivo de log 
    * @param strTextoError   texto con la incidencia que se ha de almacenar en el archivo de log
    */
   public synchronized void nuevoMensaje(String strTextoError) {     
   
      Calendar calendario = Calendar.getInstance();
      
      String strFecha = "[" + calendario.get(Calendar.DAY_OF_MONTH) + "/" + (calendario.get(Calendar.MONTH)+1) + "/" + calendario.get(Calendar.YEAR) + "]";
      String strHora = "[" + calendario.get(Calendar.HOUR_OF_DAY) + ":" + calendario.get(Calendar.MINUTE) + ":" + calendario.get(Calendar.SECOND) + "]";
      
      //Se escribe el texto del mensaje en una nueva linea
      this.m_print.println(strFecha + " " + strHora + " " + m_strClase + " " + strTextoError);     
   
      return;
   }     
}
   
   
