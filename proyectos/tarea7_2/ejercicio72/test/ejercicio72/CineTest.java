package ejercicio72;

import java.util.ArrayList;
import org.jmock.Expectations;
import static org.jmock.Expectations.returnValue;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class CineTest {

    Mockery context = new JUnit4Mockery();

    public CineTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddPelicula() {
    }

    @Test
    public void testAddSala() {
    }

    @Test
    public void testCalcularPrecioEntrada() {
    }

    @Test
    public void testPagarEntrada() throws Exception {
    }

    @Test
    public void testGetCartelera() {
    }

    @Test
    public void testGetCodigoPostal() {
    }

    @Test
    public void testGetDireccion() {
    }

    @Test
    public void testGetNombre() {
    }

    @Test
    public void testGetPoblacion() {
    }

    @Test
    public void testGetSalas() {
    }

    @Test
    public void testSetDireccion() {
    }

    @Test
    public void testListarPoblacionesConCine() {
        final Provincia provincia = context.mock(Provincia.class);
        final ArrayList<String> result = new ArrayList<String>();
        result.add("p1");
        result.add("p2");
        result.add("p3");

        context.checking(new Expectations() {
            {
                oneOf(provincia).ListarPoblaciones();
                will(returnValue(result));
            }
        });
        Cine cine = new Cine("cine1", "direccion", "poblacion", 0000, provincia, null);

        ArrayList<String> datos = cine.ListarPoblacionesConCine(provincia);
        assertEquals(result, datos);
    }

    @Test
    public void testAddPlobacionConCine() {
        final Provincia provincia = context.mock(Provincia.class);
        final ArrayList<String> datos = new ArrayList<String>();
        datos.add("pruebaEnvio");
        context.checking(new Expectations() {
            {
                oneOf(provincia).addPoblacion("pruebaEnvio");
            }
        });
        Cine cine = new Cine("cine1", "direccion", "poblacion", 0000, provincia, null);
        cine.addPlobacionConCine(provincia, "pruebaEnvio");
        context.checking(new Expectations() {
            {
                oneOf(provincia).ListarPoblaciones();
                will(returnValue(datos));
            }
        });
        ArrayList<String> resultado = new ArrayList<String>();
        resultado = cine.ListarPoblacionesConCine(provincia);
        assertEquals(datos, resultado);
    }

    @Test
    public void testAsociarActorAPeli() {
      /*  final Provincia provincia = context.mock(Provincia.class);
        final Actor actor = context.mock(Actor.class);
        final Pelicula pelicula = new Pelicula();
        final Pelicula peli2 = new Pelicula();
        peli2.addActor(actor);
        ArrayList<Pelicula> listaPelis2 = new ArrayList<Pelicula>();
        listaPelis2.add(peli2);

        Cine cine = new Cine("cine1", "direccion", "poblacion", 0000, provincia, null);

        context.checking(new Expectations() {
            {
                oneOf(actor).getPeliculas();
                will(returnValue(peli2));
            }
        });
        context.checking(new Expectations() {
            {
                oneOf(actor).addPelicula(pelicula);
            }
        });
        cine.AsociarActorAPeli(actor, pelicula);
        ArrayList<Pelicula> listaPelis = actor.getPeliculas();
        assertEquals(listaPelis2, listaPelis);*/
        //no hay metodos para saber que actores tiene una pelicula
    }

    @Test
    public void testBorrarActorAPeli() {
        final Actor actor = context.mock(Actor.class);
        Provincia provincia=context.mock(Provincia.class);
        final Pelicula pelicula = new Pelicula();
        pelicula.addActor(actor);
        final ArrayList<Pelicula> pelis=new ArrayList<Pelicula>();
        ArrayList<Pelicula> pelis2=new ArrayList<Pelicula>();
        context.checking(new Expectations() {
            {
                oneOf(actor).deletePelicula(pelicula);
            }
        });
        context.checking(new Expectations(){
                {
                    oneOf(actor).getPeliculas();
                    will(returnValue(pelis));
                }
        });
        Cine cine=new Cine("cine1", "direccion", "poblacion", 0000, provincia, null);
        cine.addPelicula(pelicula);
        cine.BorrarActorAPeli(actor, pelicula);
        pelis2=actor.getPeliculas();
        assertEquals(pelis,pelis2) ;
    }

    @Test
    public void testBuscarPeliPorActor() {
        final Actor actor = context.mock(Actor.class);
        Provincia provincia=context.mock(Provincia.class);
        final Pelicula pelicula=new Pelicula();
        final ArrayList<Pelicula> pelis2=new ArrayList<Pelicula>();
        pelis2.add(pelicula);
        context.checking(new Expectations(){
                {
                    oneOf(actor).addPelicula(pelicula);
                    
                }
        });
        context.checking(new Expectations(){
                {
                    oneOf(actor).getPeliculas();
                    will(returnValue(pelis2));
                }
        });
        actor.addPelicula(pelicula);
        Cine cine=new Cine("cine1", "direccion", "poblacion", 0000, provincia, null);
        ArrayList<Pelicula> pelis=cine.BuscarPeliPorActor(actor);
        
        assertEquals(pelis2,pelis);
        
    }

    @Test
    public void testHaySesion() throws Exception {
        final Sesion sesion=context.mock(Sesion.class);
        final Pelicula pelicula=new Pelicula();
        Provincia provincia=context.mock(Provincia.class);
        ArrayList<Sesion> sesiones=new ArrayList<Sesion>();
        ArrayList<Sesion> sesiones2;
        sesiones.add(sesion);
        context.checking(new Expectations(){
                {
                    oneOf(sesion).getPelicula();
                    will(returnValue(pelicula));
                }
        });
        context.checking(new Expectations(){
                {
                    oneOf(sesion).ConsultarPlazasLibres();
                    will(returnValue(10));
                }
        });
        context.checking(new Expectations(){
                {
                    oneOf(sesion).getDia();
                    will(returnValue(1));
                }
        });
        Cine cine=new Cine("cine1", "direccion", "poblacion", 0000, provincia, null);
        sesiones2=cine.haySesion(pelicula, 1);
        assertEquals(sesiones,sesiones2);
    }

    @Test
    public void testComprarEntrada() {
        final Sesion sesion=context.mock(Sesion.class);
        final Pelicula pelicula=new Pelicula();
        Provincia provincia=context.mock(Provincia.class);
        context.checking(new Expectations(){
                {
                    exactly(2).of(sesion).ConsultarPlazasLibres();
                   will(returnValue(4));
                   
                }
        });
        context.checking(new Expectations(){
                {
                    oneOf(sesion).DecrementarNumPlazasLibres(2);                   
                }
        });
        Cine cine=new Cine("cine1", "direccion", "poblacion", 0000, provincia, null);
        assertEquals(true,cine.ComprarEntrada(sesion, 2));
        
        assertEquals(false,cine.ComprarEntrada(sesion, 4));
        
    }

    @Test
    public void testGetSesionesPorFechaYPelicula() {
         //sesion.getpelicula() devuleve pelicula
        //en otros metodos se utiliza asi. No se puede definir otro metodo que devuelva un string
    }

}
