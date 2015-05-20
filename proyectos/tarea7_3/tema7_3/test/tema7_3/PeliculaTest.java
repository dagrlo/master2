/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema7_3;

import java.io.File;
import java.sql.Connection;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
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
public class PeliculaTest {

    private static Connection con;
    private static IDatabaseConnection conexion;

    public PeliculaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws DatabaseUnitException {
         //Base de datos real
        Conexion setupC = new Conexion();
        con = setupC.conecta();
        conexion = new DatabaseConnection(con);
    }
    
      private void cargaDataset(String cual) throws Exception{
        IDataSet dataset = new FlatXmlDataSet(new File(cual));
        try {
            DatabaseOperation.CLEAN_INSERT.execute(conexion, dataset);
        } finally {
           // con.close();
        }
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
    public void testAddActor() throws Exception {
        cargaDataset("pelis_dataset.xml");
        Pelicula pelicula=new Pelicula();
        Actor actor=new Actor();
        actor.setNombre("actor01");
        actor.setApellidos("actor02");
        pelicula.addActor(actor);
        
    }

}
