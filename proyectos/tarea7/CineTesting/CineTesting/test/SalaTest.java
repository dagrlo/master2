

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SalaTest {
    
    private  Sala salaPruebas;
    
    public SalaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Cine cine=null;
        salaPruebas=new Sala(cine,10,100);
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void testGetNum_sala() {       
        int result = salaPruebas.getNum_sala();
        assertEquals("Get num sala ",10, result);        
    }

    @Test(expected=Exception.class)
    public void testSetNum_asientos() throws Exception {
       
        int num_asientos = 100;
        int max_capacidad = 30;       
        salaPruebas.setNum_asientos(num_asientos, max_capacidad);        
        
    }

    @Test
    public void testSetNum_sala() {
        System.out.println("setNum_sala");
        int num_sala = 0;
       
        salaPruebas.setNum_sala(num_sala);
        assertEquals("Set num sala",num_sala,salaPruebas.getNum_sala());
        
    }
    
}
