import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrincipalTest {
    
    public PrincipalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

  
    @Test
    public void testInvertir() {
        
        int[] arreglo = {1,2,3,4,5,6,7,8};
        int[] solucion = {8,7,6,5,4,3,2,1};
        
        Principal.invertir(arreglo);    
       
        assertArrayEquals("Invertir ",solucion,arreglo);
    }
 
    @Test
    public void testSumar() {      
        int[] arreglo = {1,1,1,1,1,1};
        int expResult = 6;
        int result = Principal.sumar(arreglo);
        assertEquals("Sumar ",expResult, result);        
    }
 
    @Test
    public void testRestar() {       
        int[] arreglo = {1,1,1,1};
        int expResult = -4;
        int result = Principal.restar(arreglo);
        assertEquals("Restar ",expResult, result);    
    }

 
    @Test
    public void testContarPares() {       
        int[] arreglo = {1,2,3,4,5,6,7,8};
        int expResult = 4;
        int result = Principal.ContarPares(arreglo);
        assertEquals("Contar pares ",expResult, result);        
    }

 
}
