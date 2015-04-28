/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejer_7_2;

import java.util.ArrayList;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author alumno
 */
@RunWith(JMock.class)
public class CineTest {
    
     Mockery context = new JUnit4Mockery();
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addPelicula method, of class Cine.
     */
    @Test
    public void testAddPelicula() {
        System.out.println("addPelicula");
        Pelicula pelicula = null;
        Cine instance = null;
        instance.addPelicula(pelicula);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSala method, of class Cine.
     */
    @Test
    public void testAddSala() {
        System.out.println("addSala");
        Sala sala = null;
        Cine instance = null;
        instance.addSala(sala);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalcularPrecioEntrada method, of class Cine.
     */
    @Test
    public void testCalcularPrecioEntrada() {
        System.out.println("CalcularPrecioEntrada");
        int numEntradas = 0;
        String temporada = "";
        Cine instance = null;
        float expResult = 0.0F;
        float result = instance.CalcularPrecioEntrada(numEntradas, temporada);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PagarEntrada method, of class Cine.
     */
    @Test
    public void testPagarEntrada() throws Exception {
        System.out.println("PagarEntrada");
        float APagar = 0.0F;
        float Pagado = 0.0F;
        Cine instance = null;
        float expResult = 0.0F;
        float result = instance.PagarEntrada(APagar, Pagado);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCartelera method, of class Cine.
     */
    @Test
    public void testGetCartelera() {
        System.out.println("getCartelera");
        Cine instance = null;
        ArrayList<Pelicula> expResult = null;
        ArrayList<Pelicula> result = instance.getCartelera();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCodigoPostal method, of class Cine.
     */
    @Test
    public void testGetCodigoPostal() {
        System.out.println("getCodigoPostal");
        Cine instance = null;
        int expResult = 0;
        int result = instance.getCodigoPostal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class Cine.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Cine instance = null;
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Cine.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Cine instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoblacion method, of class Cine.
     */
    @Test
    public void testGetPoblacion() {
        System.out.println("getPoblacion");
        Cine instance = null;
        String expResult = "";
        String result = instance.getPoblacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalas method, of class Cine.
     */
    @Test
    public void testGetSalas() {
        System.out.println("getSalas");
        Cine instance = null;
        ArrayList<Sala> expResult = null;
        ArrayList<Sala> result = instance.getSalas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class Cine.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "";
        Cine instance = null;
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * ESTA SE HACE
     */
    @Test
    public void testListarPoblacionesConCine() {
        
        final Provincia provincia = context.mock(Provincia.class);
        final ArrayList<String> result = new ArrayList<String>();
        result.add("p1");
        result.add("p2");
        result.add("p3");
        
        context.checking(new Expectations(){
                {
                    oneOf(provincia).ListarPoblaciones();
                    will(returnValue(result));
                }
        });
        Cine cine=new Cine("cine1","direccion","poblacion",0000,provincia,null);
                
        ArrayList<String> datos = cine.ListarPoblacionesConCine(provincia);
        assertEquals(result, datos);       
    }

    /**
     * ESTA TAMBIEN VA
     */
    @Test
    public void testAddPlobacionConCine() {
        final Provincia provincia=context.mock(Provincia.class);
        final ArrayList<String> datos=new ArrayList<String>();
        datos.add("pruebaEnvio");
        context.checking(new Expectations(){
                {
                    oneOf(provincia).addPoblacion("pruebaEnvio");
                }
        });
        Cine cine=new Cine("cine1","direccion","poblacion",0000,provincia,null);
        cine.addPlobacionConCine(provincia, "pruebaEnvio");
        context.checking(new Expectations(){
                {
                    oneOf(provincia).ListarPoblaciones();
                    will(returnValue(datos));
                }
        });
        ArrayList<String> resultado=new ArrayList<String>();
        resultado=cine.ListarPoblacionesConCine(provincia);
        assertEquals(datos,resultado);
        
    }

    /**
     * Test of AsociarActorAPeli method, of class Cine.
     */
    @Test
    public void testAsociarActorAPeli() {
        System.out.println("AsociarActorAPeli");
        Actor actor = null;
        Pelicula pelicula = null;
        Cine instance = null;
        instance.AsociarActorAPeli(actor, pelicula);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BorrarActorAPeli method, of class Cine.
     */
    @Test
    public void testBorrarActorAPeli() {
        System.out.println("BorrarActorAPeli");
        Actor actor = null;
        Pelicula pelicula = null;
        Cine instance = null;
        instance.BorrarActorAPeli(actor, pelicula);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarPeliPorActor method, of class Cine.
     */
    @Test
    public void testBuscarPeliPorActor() {
        System.out.println("BuscarPeliPorActor");
        Actor actor = null;
        Cine instance = null;
        ArrayList<Pelicula> expResult = null;
        ArrayList<Pelicula> result = instance.BuscarPeliPorActor(actor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of haySesion method, of class Cine.
     */
    @Test
    public void testHaySesion() throws Exception {
        System.out.println("haySesion");
        Pelicula pelicula = null;
        int dia = 0;
        Cine instance = null;
        ArrayList<Sesion> expResult = null;
        ArrayList<Sesion> result = instance.haySesion(pelicula, dia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ComprarEntrada method, of class Cine.
     */
    @Test
    public void testComprarEntrada() {
        System.out.println("ComprarEntrada");
        Sesion sesion = null;
        int num_entradas = 0;
        Cine instance = null;
        boolean expResult = false;
        boolean result = instance.ComprarEntrada(sesion, num_entradas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSesionesPorFechaYPelicula method, of class Cine.
     */
    @Test
    public void testGetSesionesPorFechaYPelicula() {
        System.out.println("getSesionesPorFechaYPelicula");
        int dia = 0;
        Pelicula pelicula = null;
        Cine instance = null;
        ArrayList<Sesion> expResult = null;
        ArrayList<Sesion> result = instance.getSesionesPorFechaYPelicula(dia, pelicula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
