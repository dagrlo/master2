/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEstadoTrafico;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jopana
 */
public class TramoTest {
    
     private Tramo m_tramo;
    
    public TramoTest() {
    }
    
    @Before
    public  void setUpClass() {
        m_tramo=new Tramo("2","-3","3","1","Retenciones","Sin accidentes");
        //Se pone Iinicio < Ifin para que lance una excepción
    }
    
    

    /**
     * Test of comprobarFormato method, of class Tramo.
     */
    
    @Test(expected=TramoMalFormadoException.class) public void comprobarFormato() throws TramoMalFormadoException {
         
      m_tramo.comprobarFormato();
   }
   
}