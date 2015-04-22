
package servidorEstadoTrafico;

//Java
import java.lang.*;
import java.util.*;

/**
* Contiene informacion relativa al estado del trafico en una  carretera en un momento dado.
* @author    <a href="mailto:Daniel.Bolanos@uam.es">Daniel Bolanos Alonso</a>
* @version   1.0
*/
public class Registro {
    
   /**
    * Identificador unico en la tabla registro para objetos cargados desde la base de datos
    */
   protected int m_iId;   
      
   /** 
    * Nombre de la carretera
    */
   protected String m_strCarretera;       
   /** 
    * Hora de la medicion  
    */
   protected String m_strHora;            
   /** 
    * Fecha de la medicion 
    */
   protected String m_strFecha;             
   /** 
    * Tramos medidos
    */
   protected Vector<Tramo> m_vTramos;              
   /** 
    * Clima
    */
   protected String m_strClima;           
   /** 
    * Obras
    */
   protected String m_strObras;                 
   
   /**
    * Constructor de la clase 
    * @param strCarretera     Nombre de la carretera
    * @param strHora          Hora de la medicion
    * @param strFecha         Fecha de la medicion
    * @param strClima         Clima
    * @param strObras         Obras
    */
   public Registro(String strCarretera, String strHora, String strFecha, String strClima, String strObras) {
      
      this.m_iId = -1;
      this.m_strCarretera = strCarretera;
      this.m_strHora = strHora;
      this.m_strFecha = strFecha;
      this.m_vTramos = new Vector<Tramo>();
      this.m_strClima = strClima;
      this.m_strObras = strObras;
   }   
      
   /**
    * Constructor de la clase para objetos cargados desde la base de datos
    * @param iId              Identificador
    * @param strCarretera     Nombre de la carretera
    * @param strHora          Hora de la medicion
    * @param strFecha         Fecha de la medicion
    * @param strClima         Clima
    * @param strObras         Obras
    */
   public Registro(int iId, String strCarretera, String strHora, String strFecha, String strClima, String strObras) {
      
      this.m_iId = iId;
      this.m_strCarretera = strCarretera;
      this.m_strHora = strHora;
      this.m_strFecha = strFecha;
      this.m_vTramos = new Vector<Tramo>();
      this.m_strClima = strClima;
      this.m_strObras = strObras;
   }   
   
   /**
    * Verifica que los datos del registro son coherentes
    * @throws   RegistroMalFormadoException		
    */
   public void comprobarFormato() throws RegistroMalFormadoException {
      
      try {      
         
         int iHora,iMinuto,iSegundo;
         int iDia,iMes,iAno;
         int iTramos;
      
         iTramos = this.m_vTramos.size();
         
         //obtencion de la hora en hora:minutos:segundos
         StringTokenizer st = new StringTokenizer(this.m_strHora,":");
         if (st.hasMoreTokens()) {
            iHora = Integer.parseInt(st.nextToken());
         } else {
            throw new RegistroMalFormadoException("Hora de captura incorrecta");
         }
         if (st.hasMoreTokens()) {
            iMinuto = Integer.parseInt(st.nextToken());
         } else {
            throw new RegistroMalFormadoException("Minuto de captura incorrecto");
         }
         if (st.hasMoreTokens()) {
            iSegundo = Integer.parseInt(st.nextToken());
         } else {
            throw new RegistroMalFormadoException("Segundo de captura incorrecto");
         }
         
         //obtencion de la fecha en dia/mes/ano
         st = new StringTokenizer(this.m_strFecha,"/"); 
         if (st.hasMoreTokens()) {
            iDia = Integer.parseInt(st.nextToken());
         } else {
            throw new RegistroMalFormadoException("Dia de captura incorrecto");
         }
         if (st.hasMoreTokens()) {
            iMes = Integer.parseInt(st.nextToken());
         } else {
            throw new RegistroMalFormadoException("Mes de captura incorrecto");
         }
         if (st.hasMoreTokens()) {
            iAno = Integer.parseInt(st.nextToken());
         } else {
            throw new RegistroMalFormadoException("Ano de captura incorrecto");
         }
        
         //comprobaciones
         if (iTramos < 1) 
            throw new RegistroMalFormadoException("no se han definido tramos para la carretera.");
         if ((iHora < 0) || (iHora > 23)) 
            throw new RegistroMalFormadoException("hora de captura incorrecta.");
         if ((iMinuto < 0) || (iMinuto > 59)) 
            throw new RegistroMalFormadoException("minuto de captura incorrecto.");
         if ((iSegundo < 0) || (iSegundo > 59)) 
            throw new RegistroMalFormadoException("segundo de captura incorrecto.");
         if ((iDia < 1) || (iDia > 31)) 
            throw new RegistroMalFormadoException("dia de captura incorrecto.");
         if ((iMes < 0) || (iMes > 59)) 
            throw new RegistroMalFormadoException("mes de captura incorrecto.");
         if (iAno < 2007) 
            throw new RegistroMalFormadoException("ano de captura incorrecto.");                    
      
      } catch (NumberFormatException e) {
         
         throw new RegistroMalFormadoException("La informacion asociada al objeto registro es inconsistente.");
      }    	
   }
   
   /**
    * Anade un tramo al registro
    * @param tramo   objeto <code>Tramo</code> a anadir
    */
   public void anadirTramo(Tramo tramo) {
      
      this.m_vTramos.add(tramo);
   }
   
   /**
    * Devuelve el numero de tramos
    * @return   numero de tramos
    */
   public int obtenerNumeroTramos() {
      
      return this.m_vTramos.size();
   }
   
   /**
    * Devuelve un tramo a partir de su indice (el primero es <code>0</code>) o <code>null</code> en caso de error
    * @param iTramo   indice del tramo a devolver     
    * @return         tramo correspondiente o <code>null</code> en caso de no existir  
    */
   public Tramo obtenerTramo(int iTramo) {
      
      //Se comprueba que el indice es valido
      if ((iTramo < 0) || (iTramo+1 > this.m_vTramos.size()))
         return null;   
      
      return (Tramo)this.m_vTramos.get(iTramo);
   }
   
   /**
    * Devuelve los tramos contenidos en el registro
    * @return   tramos contenidos en el objeto <code>Registro</code>
    */
   public Vector<Tramo> obtenerTramos() {
      
      return this.m_vTramos;      
   }
   
   /**
    * Devuelve el identificador del objeto en la tabla registro
    * @return   identificador           
    */
   public int obtenerId() {
      
      return this.m_iId;
   }
   
   /**
    * Devuelve la carretera
    * @return   nombre de la carretera           
    */
   public String obtenerCarretera() {
      
      return this.m_strCarretera;
   }
   
   /**
    * Devuelve la hora de la medicion en formato texto
    * @return   hora de la medicion
    */
   public String obtenerHora() {
      
      return this.m_strHora;
   }
   
   /**
    * Devuelve la fecha de la medicion en formato texto
    * @return   fecha de la medicion
    */
   public String obtenerFecha() {
      
      return this.m_strFecha;
   }  
   
   /**
    * Devuelve el clima    
    * @return   clima
    */
   public String obtenerClima() {
      
      return this.m_strClima;  
   }
   
   /**
    * Devuelve las obras
    * @return   obras  
    */
   public String obtenerObras() {
      
      return this.m_strObras;
   }
   
   /**
    * Devuelve la longitud total de la carretera
    */
   public int obtenerLongitud() {
   	
   	int iLongitud = 0;
   	
	   for(int i = 0; i < this.m_vTramos.size() ; ++i) {
	   	iLongitud += this.m_vTramos.get(i).obtenerLongitud();	   	
	   }      

   	return iLongitud;
   }      
      
   /**
    * Modifica el identificador del objeto en la tabla registro de la base de datos
    * @param iId   identificador del objeto en la tabla registro           
    */
   public void modificarId(int iId) {
      
      this.m_iId = iId;
   }
   	
   /**
    * Modifica el nombre de la carretera
    * @param strCarretera   nombre de la carretera
    */
   public void modificarCarretera(String strCarretera) {
      
      this.m_strCarretera = strCarretera;
   }
   
   /**
    * Modifica la hora
    * @param strHora   hora de la medicion
    */
   public void modificarHora(String strHora) {
      
      this.m_strHora = strHora;
   }
   
   /**
    * Modifica la fecha             
    * @param strFecha   fecha de la medicion
    */
   public void modificarFecha(String strFecha) {
      
      this.m_strFecha = strFecha;
   }  
   
   /**
    * Modifica el clima    
    * @param strClima   clima
    */
   public void modificarClima(String strClima) {
      
      this.m_strClima = strClima;  
   }
   
   /**
    * Modifica las obras
    * @param strObras   obras  
    */
   public void modificarObras(String strObras) {
      
      this.m_strObras = strObras;
   }
}
      
      
   
   
   
   
   
   