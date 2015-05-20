/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema7_3;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.Arrays;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.assertion.DbUnitAssert;
import org.dbunit.dataset.*;
import org.dbunit.dataset.xml.*;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yo
 */
public class CineTest {

    private static Connection con;
    private static IDatabaseConnection conexion;

    public CineTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //Base de datos real
        Conexion setupC = new Conexion();
        con = setupC.conecta();
        conexion = new DatabaseConnection(con);
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

    private void cargaDataset(String cual) throws Exception {
        IDataSet dataset = new FlatXmlDataSet(new File(cual));
        try {
            DatabaseOperation.CLEAN_INSERT.execute(conexion, dataset);
        } finally {
            // con.close();
        }
    }

    @Test
    public void testListarPoblacionesConCine() throws Exception {
        cargaDataset("poblaciones_dataset.xml");
        Cine repository = new Cine();
        Provincia provincia = new Provincia();
        ArrayList<String> lista0 = new ArrayList<String>(Arrays.asList("Albal", "Paiporta", "Valencia"));
        ArrayList<String> lista1 = repository.ListarPoblacionesConCine(provincia);
        assertEquals("ListarPoblacionesConcine", lista0, lista1);
    }

    @Test
    public void testBuscarPeliPorActor() throws Exception {
        cargaDataset("pelis_dataset.xml");
        Cine cine = new Cine();
        Actor actor = new Actor(0);
        ArrayList<String> lista1 = cine.BuscarPeliPorActor(actor);
        ArrayList<String> lista0 = new ArrayList<String>(Arrays.asList("peli1", "peli2", "peli3"));

        assertEquals("BuscarPeliPorActor", lista0, lista1);
    }

    @Test
    public void testHaySesion() throws Exception {
        cargaDataset("sesion_dataset.xml");
        Cine cine = new Cine();
        ArrayList<String> lista1 = cine.haySesion(0, "h1");
        ArrayList<String> lista0 = new ArrayList<String>(Arrays.asList("sesion01"));

        assertEquals("HaySesion", lista0, lista1);
    }

    @Test
    public void testComprarEntrada() throws Exception {
        cargaDataset("sesion_dataset.xml");
        Cine cine = new Cine();

        assertEquals("comprarEntrada FALSE", false, cine.ComprarEntrada(0, 21));
        assertEquals("comprarEntrada FALSE", true, cine.ComprarEntrada(0, 3));
    }

}
