import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PeliculaTest {
    
    private Pelicula pelicula,pelicula2;
    private ArrayList<Integer> valoraciones;
    
    public PeliculaTest() {
    }
    
  
    
    @Before
    public void setUp() {
        pelicula=new Pelicula("Pelicula01","Sinopsis","1/4/2015","tipo","clasificacion",500);
        pelicula2=pelicula;
        valoraciones = new ArrayList<Integer>();
        valoraciones.add(1);
        valoraciones.add(2);
        valoraciones.add(3);
        valoraciones.add(4);
        valoraciones.add(5);
        valoraciones.add(6);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddGetValoracion() throws Exception {
        //este test añade valoraciones y luego las lee para comparar
        for (Integer valoracion : valoraciones) {
            pelicula.addValoracion(valoracion);
        }
        ArrayList<Integer> leidas=pelicula.getValoraciones();
        Assert.assertEquals("Valoraciones ",valoraciones, leidas);                 
    }

    @Test
    public void testDeleteValoracion() throws Exception {
        int tamaOrig,tamaFin;
        
        for (Integer valoracion : valoraciones) {
            pelicula2.addValoracion(valoracion);
        }
        tamaOrig=pelicula2.NumValoracion();
        pelicula2.deleteValoracion(0);
        tamaFin=pelicula2.NumValoracion();
        Assert.assertNotSame("Delete valoraciones ",tamaOrig, tamaFin);
    }

    @Test
    public void testNumValoracion() {
        
        Pelicula instance = new Pelicula();
        int expResult = 0;
        int result = instance.NumValoracion();
        assertEquals("Num. Valoraciones ",expResult, result);
        
    }

    @Test
    public void testGetTitulo() {                
        String result = pelicula.getTitulo();
        assertEquals("Get titulo ","Pelicula01", result);        
    }

   

   
    
}
