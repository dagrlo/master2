
package servidorEstadoTrafico;

//Java
import java.lang.*;
import java.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
* Se encarga de construir documentos XML a partir de informacion acerca del estado de las carreteras
* @author    <a href="mailto:Daniel.Bolanos@uam.es">Daniel Bolanos Alonso</a>
* @version   1.0
*/
public class GeneradorXML {   
   
   /**
    * Objeto de Log
    */
   private Log m_log;
      
   /**
    * Constructor de la clase
    */
   public GeneradorXML(Log log) {    
       
       this.m_log = log;      
   }   
   
   /**
    * Construye un documento XML con un registro
    * @param registro   registro con la informacion con la que construir el documento XML
    * @return           documento xml construido o <code>null</code> en caso de error
    */
   public Document construirXMLRegistro(Registro registro) { 
   
      Document documento = null;
   
      try {     
      
         DocumentBuilderFactory domFactory = null;
         DocumentBuilder domBuilder = null;
         Tramo tramo;
         
         domFactory = DocumentBuilderFactory.newInstance();
         domBuilder = domFactory.newDocumentBuilder();              
         documento = domBuilder.newDocument();                 
         
         Element rootElement = documento.createElement("REGISTRO");
         documento.appendChild(rootElement);
         
         Element element = documento.createElement("Carretera");
         element.appendChild(documento.createTextNode(registro.obtenerCarretera()));
         rootElement.appendChild(element);
         
         element = documento.createElement("Hora");
         element.appendChild(documento.createTextNode(registro.obtenerHora()));
         rootElement.appendChild(element);
         
         element = documento.createElement("Fecha");
         element.appendChild(documento.createTextNode(registro.obtenerFecha()));         
         rootElement.appendChild(element); 

         element = documento.createElement("Clima");
         element.appendChild(documento.createTextNode(registro.obtenerClima()));         
         rootElement.appendChild(element); 

         element = documento.createElement("Obras");
         element.appendChild(documento.createTextNode(registro.obtenerObras()));         
         rootElement.appendChild(element); 
         
         //Se escribe la informacion de los tramos
         for(int i=0;i<registro.obtenerNumeroTramos();++i) {  
         
            //Se toma el tramo
            tramo = registro.obtenerTramo(i);          
       
            element = documento.createElement("Tramo");        
            
            Element child = documento.createElement("PuntoKilometricoInicio");         
            child.appendChild(documento.createTextNode(tramo.obtenerKMInicio()));         
            element.appendChild(child);                  
            
            child = documento.createElement("PuntoKilometricoFin");         
            child.appendChild(documento.createTextNode(tramo.obtenerKMFin()));         
            element.appendChild(child);                  
            
            child = documento.createElement("Carriles");         
            child.appendChild(documento.createTextNode(tramo.obtenerCarriles()));         
            element.appendChild(child);                  
            
            child = documento.createElement("CarrilesCortados");         
            child.appendChild(documento.createTextNode(tramo.obtenerCarrilesCortados()));         
            element.appendChild(child);                  
            
            child = documento.createElement("Estado");         
            child.appendChild(documento.createTextNode(tramo.obtenerEstado()));         
            element.appendChild(child);                  
            
            child = documento.createElement("Accidentes");         
            child.appendChild(documento.createTextNode(tramo.obtenerAccidentes()));         
            element.appendChild(child);                  
            
            rootElement.appendChild(element);            
         }                 
      
      } catch (FactoryConfigurationError error) {
      	
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLRegistro");
         
         return null;         
         
      } catch (ParserConfigurationException exception) {
         
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLRegistro");
         
         return null;         
         
      } catch (DOMException exception) {

         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLRegistro");
         
         return null;         
      }
      
      return documento;      
   }    
   
   /**
    * Construye un documento XML con las carreteras que tienen obras
    * @param vRegistros   registros con la informacion con la que construir el documento XML
    * @return             documento xml construido o <code>null</code> en caso de error
    */
   public Document construirXMLCarreterasObras(Vector vRegistros) {
      
      Document documento = null;
   
      try {     
      
         DocumentBuilderFactory domFactory = null;
         DocumentBuilder domBuilder = null;
         Tramo tramo;
         
         domFactory = DocumentBuilderFactory.newInstance();
         domBuilder = domFactory.newDocumentBuilder();              
         documento = domBuilder.newDocument();                       
         
         Element rootElement = documento.createElement("OBRAS");
         documento.appendChild(rootElement);                
               
         //Se recorre el vector de registros y se inserta en el documento XML el nombre de las carreteras que estan en obras
         for (Enumeration e = vRegistros.elements() ; e.hasMoreElements() ;) {                     
            
            //Se toma el registro
            Registro registro = (Registro)e.nextElement();           
            
            //Si la carretera esta en obras se anade al documento
            if (registro.obtenerObras().compareTo("Si") == 0) {
               
               Element element = documento.createElement("Carretera");
               element.appendChild(documento.createTextNode(registro.obtenerCarretera()));
               rootElement.appendChild(element);                     
            }               
         }
            
      } catch (FactoryConfigurationError error) {
      	
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLCarreterasObras");
         
         return null;         
         
      } catch (ParserConfigurationException exception) {
      	
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLCarreterasObras");
         
         return null;         
         
      } catch (DOMException exception) {

         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLCarreterasObras");
         
         return null;         
      }
  
      return documento;  
   }   
   
   /**
    * Construye un documento XML con las carrerteras que tienen accidentes
    * @param vRegistros   registros con la informacion con la que construir el documento XML
    * @return             documento xml construido o <code>null</code> en caso de error 
    */
   public Document construirXMLCarreterasAccidentes(Vector vRegistros) {
      
      Document documento = null;
   
      try {     
      
         DocumentBuilderFactory domFactory = null;
         DocumentBuilder domBuilder = null;
         Tramo tramo;
         
         domFactory = DocumentBuilderFactory.newInstance();
         domBuilder = domFactory.newDocumentBuilder();              
         documento = domBuilder.newDocument();                       
         
         Element rootElement = documento.createElement("ACCIDENTES");
         documento.appendChild(rootElement);       
      
         //Se recorre el vector de registros y se inserta en el documento XML el nombre de las carreteras que estan en obras
         for (Enumeration e = vRegistros.elements() ; e.hasMoreElements() ;) {                     
            
            //Se toma el registro
            Registro registro = (Registro)e.nextElement();           
            
            //Se mira los tramos para ver si tienen accidentes
            for(int i=0;i<registro.obtenerNumeroTramos();++i) {          
            
               //Se toma el tramo
               tramo = registro.obtenerTramo(i);
               
               //En caso de que el tramo tenga accidentes se anade al documento XML               
               if (tramo.obtenerAccidentes().compareTo("Sin accidentes") != 0) {                   
		          
		            Element element = documento.createElement("Tramo");        
		            
		            Element child = documento.createElement("Carretera");         
		            child.appendChild(documento.createTextNode(registro.obtenerCarretera()));         
		            element.appendChild(child);                  
		          
		            child = documento.createElement("PuntoKilometricoInicio");         
		            child.appendChild(documento.createTextNode(tramo.obtenerKMInicio()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("PuntoKilometricoFin");         
		            child.appendChild(documento.createTextNode(tramo.obtenerKMFin()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("Carriles");         
		            child.appendChild(documento.createTextNode(tramo.obtenerCarriles()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("CarrilesCortados");         
		            child.appendChild(documento.createTextNode(tramo.obtenerCarrilesCortados()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("Estado");         
		            child.appendChild(documento.createTextNode(tramo.obtenerEstado()));         
		            element.appendChild(child);                  		            
		          
		            child = documento.createElement("Accidentes");         
		            child.appendChild(documento.createTextNode(tramo.obtenerAccidentes()));         
		            element.appendChild(child);                  		            
		            
		            rootElement.appendChild(element);            		          	                                     
	            }              
            }               
         }
            
      } catch (FactoryConfigurationError error) {
      	
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLCarreterasAccidentes");
         
         return null;         
         
      } catch (ParserConfigurationException exception) {
         
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLCarreterasAccidentes");
         
         return null;         
         
      } catch (DOMException exception) {

         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLCarreterasAccidentes");
         
         return null;         
      }
  
      return documento;  
   }         
   
   /**
    * Construye un documento XML con los tramos que tienen ms trafico
    * @param vRegistros   registros con la informacion con la que construir el documento XML
    * @return             documento xml construido o <code>null</code> en caso de error 
    */
   public Document construirXMLTramosMasTrafico(Vector vRegistros) {
   	
      Document documento = null;            
   
      try {     
      
         DocumentBuilderFactory domFactory = null;
         DocumentBuilder domBuilder = null;
         Tramo tramo;
         
         domFactory = DocumentBuilderFactory.newInstance();
         domBuilder = domFactory.newDocumentBuilder();              
         documento = domBuilder.newDocument();               
         
         Element rootElement = documento.createElement("TRAMOS_MAS_TRAFICO");
         documento.appendChild(rootElement);          
      
         //Se recorre el vector de registros y se inserta en el XML los tramos que tengan mas trafico
         for (Enumeration e = vRegistros.elements() ; e.hasMoreElements() ;) {                     
            
            //Se toma el registro
            Registro registro = (Registro)e.nextElement();           
            
            //Se mira uno por uno los tramos
            for(int i=0;i<registro.obtenerNumeroTramos();++i) {          
            
               //Se toma el tramo
               tramo = registro.obtenerTramo(i);
               
               //En caso de que el tramo sea de los que mas trafico tienen se anade al XML               
               if (tramo.obtenerEstado().compareTo("Retenciones") == 0) {                   
		          
		            Element element = documento.createElement("Tramo");        
		            
  		            Element child = documento.createElement("Carretera");         
  		            child.appendChild(documento.createTextNode(registro.obtenerCarretera()));         
		            element.appendChild(child);                  
		          
		            child = documento.createElement("PuntoKilometricoInicio");         
		            child.appendChild(documento.createTextNode(tramo.obtenerKMInicio()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("PuntoKilometricoFin");         
		            child.appendChild(documento.createTextNode(tramo.obtenerKMFin()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("Carriles");         
		            child.appendChild(documento.createTextNode(tramo.obtenerCarriles()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("CarrilesCortados");         
		            child.appendChild(documento.createTextNode(tramo.obtenerCarrilesCortados()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("Estado");         
		            child.appendChild(documento.createTextNode(tramo.obtenerEstado()));         
		            element.appendChild(child);                  		            
		          
		            child = documento.createElement("Accidentes");         
		            child.appendChild(documento.createTextNode(tramo.obtenerAccidentes()));         
		            element.appendChild(child);                  		            
		            
		            rootElement.appendChild(element);            		          	                                     
	            }               
            }               
         }
            
      } catch (FactoryConfigurationError error) {
      	
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLTramosMasTrafico");
         
         return null;         
         
      } catch (ParserConfigurationException exception) {
         
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLTramosMasTrafico");
         
         return null;         
         
      } catch (DOMException exception) {

         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLTramosMasTrafico");
         
         return null;         
      }
  
      return documento;  
   }      
   
   /**
    * Construye un documento XML con los tramos que tienen menos trafico
    * @param vRegistros   registros con la informacion con la que construir el documento XML
    * @return             documento xml construido o <code>null</code> en caso de error 
    */
   public Document construirXMLTramosMenosTrafico(Vector vRegistros) {
   	
      Document documento = null;
   
      try {     
      
         DocumentBuilderFactory domFactory = null;
         DocumentBuilder domBuilder = null;
         Tramo tramo;
         
         domFactory = DocumentBuilderFactory.newInstance();
         domBuilder = domFactory.newDocumentBuilder();              
         documento = domBuilder.newDocument();                       
         
         Element rootElement = documento.createElement("TRAMOS_MENOS_TRAFICO");
         documento.appendChild(rootElement);       
      
         //Se recorre el vector de registros e insertamos en el XML los tramos que tengan menos trfico
         for (Enumeration e = vRegistros.elements() ; e.hasMoreElements() ;) {                     
            
            //Se toma el registro
            Registro registro = (Registro)e.nextElement();           
            
            //Se mira uno por uno los tramos
            for(int i=0;i<registro.obtenerNumeroTramos();++i) {          
            
               //Se toma el tramo
               tramo = registro.obtenerTramo(i);
               
               //En caso de que el tramo sea de los que menos trafico tienen se anade al XML               
               if (tramo.obtenerEstado().compareTo("Trafico fluido") == 0) {                   
		          
		            Element element = documento.createElement("Tramo");        
		            
		            Element child = documento.createElement("Carretera");         
		            child.appendChild(documento.createTextNode(registro.obtenerCarretera()));         
		            element.appendChild(child);                  
		          
		            child = documento.createElement("PuntoKilometricoInicio");         
		            child.appendChild(documento.createTextNode(tramo.obtenerKMInicio()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("PuntoKilometricoFin");         
		            child.appendChild(documento.createTextNode(tramo.obtenerKMFin()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("Carriles");         
		            child.appendChild(documento.createTextNode(tramo.obtenerCarriles()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("CarrilesCortados");         
		            child.appendChild(documento.createTextNode(tramo.obtenerCarrilesCortados()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("Estado");         
		            child.appendChild(documento.createTextNode(tramo.obtenerEstado()));         
		            element.appendChild(child);                  		            
		          
		            child = documento.createElement("Accidentes");         
		            child.appendChild(documento.createTextNode(tramo.obtenerAccidentes()));         
		            element.appendChild(child);                  		            
		            
		            rootElement.appendChild(element);            		          	                                     
	           }
               
            }               
         }
            
      } catch (FactoryConfigurationError error) {
      	
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLTramosMenosTrafico");
         
         return null;         
         
      } catch (ParserConfigurationException exception) {
         
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLTramosMenosTrafico");
         
         return null;         
         
      } catch (DOMException exception) {

         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLTramosMenosTrafico");
         
         return null;         
      }
  
      return documento;  
   }
   
   /**
    * Construye un documento XML con los tramos que tienen carriles cortados
    * @param vRegistros   registros con la informacion con la que construir el documento XML
    * @return             documento xml construido o <code>null</code> en caso de error 
    */
   public Document construirXMLCarrilesCortados(Vector vRegistros) {
   	
      Document documento = null;
   
      try {     
      
         DocumentBuilderFactory domFactory = null;
         DocumentBuilder domBuilder = null;
         Tramo tramo;
         
         domFactory = DocumentBuilderFactory.newInstance();
         domBuilder = domFactory.newDocumentBuilder();              
         documento = domBuilder.newDocument();                       
         
         Element rootElement = documento.createElement("CARRILES_CORTADOS");
         documento.appendChild(rootElement);       
      
         //Se recorre el vector de registros y se inserta en el documento XML los tramos que tengan carriles cortados
         for (Enumeration e = vRegistros.elements() ; e.hasMoreElements() ;) {                     
            
            //Se toma el registro
            Registro registro = (Registro)e.nextElement();           
            
            //Se miran los tramos para ver si tienen carriles cortados
            for(int i=0;i<registro.obtenerNumeroTramos();++i) {          
            
               //Se toma el tramo
               tramo = registro.obtenerTramo(i);
               
               //En caso de que el tramo tenga carriles cortados se anade al documento XML               
               if (tramo.obtenerCarrilesCortados().compareTo("0") != 0) {                   
		          
		            Element element = documento.createElement("Tramo");        
		            
		            Element child = documento.createElement("Carretera");         
		            child.appendChild(documento.createTextNode(registro.obtenerCarretera()));         
		            element.appendChild(child);                  
		          
		            child = documento.createElement("PuntoKilometricoInicio");         
		            child.appendChild(documento.createTextNode(tramo.obtenerKMInicio()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("PuntoKilometricoFin");         
		            child.appendChild(documento.createTextNode(tramo.obtenerKMFin()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("Carriles");         
		            child.appendChild(documento.createTextNode(tramo.obtenerCarriles()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("CarrilesCortados");         
		            child.appendChild(documento.createTextNode(tramo.obtenerCarrilesCortados()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("Estado");         
		            child.appendChild(documento.createTextNode(tramo.obtenerEstado()));         
		            element.appendChild(child);                  		            
		          
		            child = documento.createElement("Accidentes");         
		            child.appendChild(documento.createTextNode(tramo.obtenerAccidentes()));         
		            element.appendChild(child);                  		            
		            
		            rootElement.appendChild(element);            		          	                                     
	            }               
            }               
         }
            
      } catch (FactoryConfigurationError error) {
      	
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLCarrilesCortados");
         
         return null;         
         
      } catch (ParserConfigurationException exception) {
         
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLCarrilesCortados");
         
         return null;         
         
      } catch (DOMException exception) {

         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLCarrilesCortados");
         
         return null;         
      }
  
      return documento;  
   } 
   
   /**
    * Construye un documento XML con la informacion de una carretera
    * @param vRegistros     registros con la informacion con la que construir el documento XML
    * @param strCarretera   carretera por la que se pregunta
    * @return               documento xml construido o <code>null</code> en caso de error 
    */
   public Document construirXMLCarretera(Vector vRegistros, String strCarretera) { 
   
      Document documento = null;
      boolean bCarreteraEncontrada = false;
   
      try {     
      
         DocumentBuilderFactory domFactory = null;
         DocumentBuilder domBuilder = null;
         Tramo tramo;
         
         domFactory = DocumentBuilderFactory.newInstance();
         domBuilder = domFactory.newDocumentBuilder();              
         documento = domBuilder.newDocument();                 
         
         Element rootElement = documento.createElement("CARRETERA");
         documento.appendChild(rootElement);
               
         //Se recorre el vector de registros y se inserta en el documento XML la carretera         
         for (Enumeration e = vRegistros.elements() ; e.hasMoreElements() ;) {                             
         
            //Se toma el registro
            Registro registro = (Registro)e.nextElement();           
            
            //En caso de haber encontrado la carretera, se inserta en el documento XML
            if (registro.obtenerCarretera().compareTo(strCarretera) == 0) {              
         
		         Element element = documento.createElement("Carretera");
		         element.appendChild(documento.createTextNode(registro.obtenerCarretera()));
		         rootElement.appendChild(element);
		         
		         element = documento.createElement("Hora");
		         element.appendChild(documento.createTextNode(registro.obtenerHora()));
		         rootElement.appendChild(element);
		         
		         element = documento.createElement("Fecha");
		         element.appendChild(documento.createTextNode(registro.obtenerFecha()));         
		         rootElement.appendChild(element); 
		
	  	         element = documento.createElement("Clima");
	  	         element.appendChild(documento.createTextNode(registro.obtenerClima()));         
		         rootElement.appendChild(element); 
		
		         element = documento.createElement("Obras");
		         element.appendChild(documento.createTextNode(registro.obtenerObras()));         
		         rootElement.appendChild(element); 
		         
		         //Se escrite la informacion de los tramos
		         for(int i=0;i<registro.obtenerNumeroTramos();++i) {  
		         
		            //Se toma el tramo
		            tramo = registro.obtenerTramo(i);          
		       
		            element = documento.createElement("Tramo");        
		            
		            Element child = documento.createElement("PuntoKilometricoInicio");         
		            child.appendChild(documento.createTextNode(tramo.obtenerKMInicio()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("PuntoKilometricoFin");         
		            child.appendChild(documento.createTextNode(tramo.obtenerKMFin()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("Carriles");         
		            child.appendChild(documento.createTextNode(tramo.obtenerCarriles()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("CarrilesCortados");         
		            child.appendChild(documento.createTextNode(tramo.obtenerCarrilesCortados()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("Estado");         
		            child.appendChild(documento.createTextNode(tramo.obtenerEstado()));         
		            element.appendChild(child);                  
		            
		            child = documento.createElement("Accidentes");         
		            child.appendChild(documento.createTextNode(tramo.obtenerAccidentes()));         
		            element.appendChild(child);                  
		            
		            rootElement.appendChild(element);            
		         } 
		       
		         //Se termina la construccion del documento
		         bCarreteraEncontrada = true;
		         break;        
		      }
		   }//Fin del bucle for principal	 
		 
		   if (bCarreteraEncontrada == false)
		      return null;
      
      } catch (FactoryConfigurationError error) {
      	
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLCarretera");
         
         return null;                  
         
      } catch (ParserConfigurationException exception) {
         
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLCarretera");
         
         return null;              
         
      } catch (DOMException exception) {

         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLCarretera");
         
         return null;         
      }
      
      return documento;      
   }    
   
   /**
    * Construye un documento XML con las carreteras que tienen un determinado clima
    * @param vRegistros   registros con la informacion con la que construir el documento XML
    * @param strClima     clima por el que se pregunta
    * @return             documento xml construido o <code>null</code> en caso de error
    */
   public Document construirXMLClima(Vector vRegistros, String strClima) { 
   
      Document documento = null; 
      boolean bCarreteraEncontrada=false;     
   
      try {     
      
         DocumentBuilderFactory domFactory = null;
         DocumentBuilder domBuilder = null;
         Tramo tramo;
         
         domFactory = DocumentBuilderFactory.newInstance();
         domBuilder = domFactory.newDocumentBuilder();              
         documento = domBuilder.newDocument();                 
         
         Element rootElement = documento.createElement("CLIMA");
         documento.appendChild(rootElement);
               
         //Se recorre el vector de registros y se inserta en el documento XML la carretera         
         for (Enumeration e = vRegistros.elements() ; e.hasMoreElements() ;) {                             
         
            //Se toma el registro
            Registro registro = (Registro)e.nextElement();           
            
            //En caso de haber encontrado una carretera con ese clima, se inserta en el documento XML
            if (registro.obtenerClima().compareTo(strClima) == 0) {              
         
               Element element = documento.createElement("Carretera");
               element.appendChild(documento.createTextNode(registro.obtenerCarretera()));
               rootElement.appendChild(element);                            
               
               //Se indica que se ha encontrado una carretera con ese clima
               bCarreteraEncontrada = true;               
            }
         }//Fin del bucle for principal   
       
         if (bCarreteraEncontrada == false)
            return null;
      
      } catch (FactoryConfigurationError error) {
      	
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLClima");
         
         return null;                  
         
      } catch (ParserConfigurationException exception) {
         
         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLClima");
         
         return null;                  

      } catch (DOMException exception) {

         //Se indica en el log que ha habido un error          
         this.m_log.nuevoMensaje("Error al construir un XML, construirXMLClima");
         
         return null;         
      }
      
      return documento;      
   }  
}