/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEstadoTrafico;

import java.util.Vector;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

 public class RegistroTest {
     
     
   
   /**
    * Objeto para la prueba
    */   
   private Registro m_registro;
   
  public RegistroTest() {
    }
   
   /**
    * Inicializacion de recursos para la prueba
    */
   @Before public void inicializar() {   
      
      String strCarretera = "M-40";
      String strHora = "12:23:61";
      String strFecha = "1/3/2007";
      String strClima = "Nublado";
      String strObras = "No";    
         
      m_registro = new Registro(strCarretera,strHora,strFecha,strClima,strObras);      
      Tramo tramo1 = new Tramo("0","10","3","1","Retenciones","Sin accidentes");
      Tramo tramo2 = new Tramo("10","12","2","0","Retenciones","Sin accidentes");
      Tramo tramo3 = new Tramo("12","15","3","1","Retenciones","Sin accidentes");     
      m_registro.anadirTramo(tramo1);
      m_registro.anadirTramo(tramo2);
      m_registro.anadirTramo(tramo3);  
   }
   
   /**
    * Liberacion de recursos utilizados durante la prueba
    */
   @After public void liberar() {
      
   }  
   	
   /**
    * Prueba del constructor Registro y de los metodos get
    */
   @Test public void Registro() {
      
		//Invocacion de los metodos de prueba y verificacion de las condiciones
      assertEquals("M-40",m_registro.obtenerCarretera());
      //se ponen mas de 60 segundos para probar que lanza la excepción
      assertEquals("12:23:61",m_registro.obtenerHora());
      assertEquals("1/3/2007",m_registro.obtenerFecha());
      assertEquals("Nublado",m_registro.obtenerClima());
      assertEquals("No",m_registro.obtenerObras());
   }
   
   /**
    * Prueba de metodos get y set 
    */
   @Test(timeout=1000) public void getSet() {
      
      String strCarretera = "A-5";
      String strHora = "1:26:12";
      String strFecha = "6/4/2007";
      String strClima = "Soleado";
      String strObras = "Camion volcado en el arcen";  
         
      //Se modifican las propiedades del objeto mediante los metodos set
      m_registro.modificarCarretera(strCarretera);
      m_registro.modificarHora(strHora);
      m_registro.modificarFecha(strFecha);
      m_registro.modificarClima(strClima);
      m_registro.modificarObras(strObras);
         
      //Se comprueba que las propiedades tienen los valores esperados mediante los metodos get
      assertEquals(strCarretera,m_registro.obtenerCarretera());
      assertEquals(strHora,m_registro.obtenerHora());
      assertEquals(strFecha,m_registro.obtenerFecha());
      assertEquals(strClima,m_registro.obtenerClima());
      assertEquals(strObras,m_registro.obtenerObras());
      
   }
   
   /**
    * Prueba del metodo comprobarformato
    */
   @Test(expected=RegistroMalFormadoException.class) public void comprobarFormato() throws RegistroMalFormadoException {
         
      m_registro.comprobarFormato();
   }

   /**
	 * Prueba del metodo obtenerLongitud
	 */
   @Test public void obtenerLongitud() {
		
		assertEquals(m_registro.obtenerLongitud(),10+2+3); 
	}        
	

}