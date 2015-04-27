
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CineTest {
    
    private Cine cinePruebas;
    private ArrayList<Pelicula> cartelera0;
    private ArrayList<Sala> salas;
    
    public CineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cinePruebas=new Cine("NombreCine","Direccion","Poblacion",0001);
        cartelera0=new ArrayList<Pelicula>();
        cartelera0.add(new Pelicula("T1","S1","F1","TP1","C1",120));
        cartelera0.add(new Pelicula("T2","S2","F2","TP2","C3",120));
        cartelera0.add(new Pelicula("T3","S3","F3","TP3","C4",120));
        cartelera0.add(new Pelicula("T4","S4","F4","TP4","C5",120));
        salas=new ArrayList<Sala>();
        salas.add(new Sala(cinePruebas,1,100));
        salas.add(new Sala(cinePruebas,2,100));
        salas.add(new Sala(cinePruebas,3,100));
        salas.add(new Sala(cinePruebas,4,100));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddGetPelicula() {
        for (Pelicula peliculas:cartelera0){
            cinePruebas.addPelicula(peliculas);
        }
        ArrayList<Pelicula> lista=cinePruebas.getCartelera();
        assertEquals("Add/Get peliculas ",cartelera0,lista);
    }

    @Test
    public void testAddGetSala() {
        for (Sala sala:salas){
            cinePruebas.addSala(sala);
        }
        ArrayList<Sala> lista=cinePruebas.getSalas();
        assertEquals("Add/get salas",salas,lista);
    }

    @Test
    public void testCalcularPrecioEntrada() {        
        assertEquals("Calcula entradas. Miercoles", 30, cinePruebas.CalcularPrecioEntrada(10, "miercoles"), 0.0);
        assertEquals("Calcula entradas. Fin de semana", 80, cinePruebas.CalcularPrecioEntrada(10, "findesemana"), 0.0);
        assertEquals("Calcula entradas. Default", 50, cinePruebas.CalcularPrecioEntrada(10,""), 0.0);      
    }

    @Test(expected=Exception.class)
    public void testPagarEntrada() throws Exception {
        cinePruebas.PagarEntrada(10, 7);
    }
    
    @Test
    public void testPagarEntrada2() throws Exception {      
        float APagar = 10.0F;
        float Pagado = 20.0F;      
        float expResult = 10.0F;
        float result = cinePruebas.PagarEntrada(APagar, Pagado);
        assertEquals("Pagar entradas 2",expResult, result, 0.0);        
    }
    
}
