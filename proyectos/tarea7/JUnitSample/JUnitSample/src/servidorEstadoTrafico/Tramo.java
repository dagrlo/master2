
package servidorEstadoTrafico;

//Java
import java.lang.*;

/**
* Contiene la informacion relativa al estado del trafico de un tramo de carretera en un momento dado.
* @author    <a href="mailto:Daniel.Bolanos@uam.es">Daniel Bolanos Alonso</a>
* @version   1.0 
*/
public class Tramo {
      
   /**
    * Identificador unico en la tabla tramo para objetos cargados desde la base de datos
    */
   protected int m_iId;    
   /**
    * Kilometro de inicio del tramo
    */
   protected String m_strKMInicio;
   /**
    * Kilometro final del tramo
    */
   protected String m_strKMFin;
   /**
    * Numero de carriles
    */
   protected String m_strCarriles;
   /**
    * Numero de carriles cortados
    */
   protected String m_strCarrilesCortados;
   /**
    * Estado del tramo
    */
   protected String m_strEstado;
   /**
    * Accidentes
    */
   protected String m_strAccidentes;      

   /**
    * Constructor de la clase
    * @param strKMInicio           kilometro de inicio del tramo 
    * @param strKMFin              kilometro final del tramo                
    * @param strCarriles           numero de carriles   
    * @param strCarrilesCortados   numero de carriles cortados
    * @param strEstado             estado del tramo  
    * @param strAccidentes         accidentes
    */      
   public Tramo(String strKMInicio, String strKMFin, String strCarriles, String strCarrilesCortados, String strEstado, String strAccidentes) {
      
      this.m_strKMInicio = strKMInicio;
      this.m_strKMFin = strKMFin;
      this.m_strCarriles = strCarriles;
      this.m_strCarrilesCortados = strCarrilesCortados;
      this.m_strEstado = strEstado;
      this.m_strAccidentes = strAccidentes;      
   }
   
   /**
    * Constructor de la clase para objetos cargados desde la base de datos
    * @param iId                   identificador
    * @param strKMInicio           kilometro de inicio del tramo 
    * @param strKMFin              kilometro final del tramo                
    * @param strCarriles           numero de carriles   
    * @param strCarrilesCortados   numero de carriles cortados
    * @param strEstado             estado del tramo  
    * @param strAccidentes         accidentes
    */      
   public Tramo(int iId, String strKMInicio, String strKMFin, String strCarriles, String strCarrilesCortados, String strEstado, String strAccidentes) {
      
      this.m_iId = iId;
      this.m_strKMInicio = strKMInicio;
      this.m_strKMFin = strKMFin;
      this.m_strCarriles = strCarriles;
      this.m_strCarrilesCortados = strCarrilesCortados;
      this.m_strEstado = strEstado;
      this.m_strAccidentes = strAccidentes;      
   }   
   
   /**
    * Verifica que los datos del tramo son coherentes
    * @throws   TramoMalFormadoException 	 en caso de que la informacion asociada tenga un formato incorrecto
    */
   public void comprobarFormato() throws TramoMalFormadoException {
   	      
   	try {      
      
         int iInicio = Integer.parseInt(this.m_strKMInicio);
         int iFin = Integer.parseInt(this.m_strKMFin);
         int iCarriles = Integer.parseInt(this.m_strCarriles);
         int iCarrilesCortados = Integer.parseInt(this.m_strCarrilesCortados);
         
         if (iInicio < 0)
         	throw new TramoMalFormadoException("Valor de kilometro inicial negativo.");
         if (iCarrilesCortados < 0)
         	throw new TramoMalFormadoException("Valor de carriles cortados negativo.");
         if (iInicio > iFin) 
         	throw new TramoMalFormadoException("Valor de kilometro inicial superior a valor de kilometro final.");
         if (iCarrilesCortados > iCarriles)
         	throw new TramoMalFormadoException("Valor de carriles cortados superior a valor de carriles totales.");
      
      } catch (NumberFormatException e) {
         
         throw new TramoMalFormadoException("La informacion asociada al objeto tramo es inconsistente.");
      }   	
   }
   
   /**
    * Devuelve el identificador del objeto en la tabla tramo
    * @return   identificador           
    */
   public int obtenerId() {
      
      return this.m_iId;
   }   
   
   /**
    * Devuelve la longitud del tramo
    * @return   longitud del tramo en kilometros o <code>-1</code> en caso de error
    * @throws   NumberFormatException   en caso de error en la conversion
    */      
   public int obtenerLongitud() throws NumberFormatException {
      
      int iInicio,iFin;
      
      try {      
      
         iInicio = Integer.parseInt(this.m_strKMInicio);
         iFin = Integer.parseInt(this.m_strKMFin);
      
      } catch (NumberFormatException e) {
         
         return -1;
      }
      
      if (iInicio >= iFin)
         return -1;
      
      return iFin-iInicio;
   }        
   
   /**
    * Devuelve el punto kilometrico inicial
    * @return   kilometro de inicio del tramo 
    */      
   public String obtenerKMInicio() {
      
      return this.m_strKMInicio;
   }   
      
   /**
    * Devuelve el punto kilometrico final
    * @return   kilometro final del tramo 
    */      
   public String obtenerKMFin() {
      
      return this.m_strKMFin;
   }     
   
   /**
    * Devuelve el numero de carriles del tramo
    * @return   numero de carriles 
    */   
   public String obtenerCarriles() {
      
      return this.m_strCarriles;
   }   
   
   /**
    * Devuelve el numero de carriles cortados
    * @return   numero de carriles cortados 
    */   
   public String obtenerCarrilesCortados() {
      
      return this.m_strCarrilesCortados;
   }   
   
   /**
    * Devuelve el estado del tramo
    * @return   astado del tramo 
    */   
   public String obtenerEstado() {
      
      return this.m_strEstado;
   }   
   
   /**
    * Devuelve la informacion sobre accidentes
    * @return   accidentes 
    */   
   public String obtenerAccidentes() {
      
      return this.m_strAccidentes;
   }      
}

  



      
      