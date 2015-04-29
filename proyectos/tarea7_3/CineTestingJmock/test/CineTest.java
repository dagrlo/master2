/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
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

/**
 *
 * @author jopana
 */
public class CineTest {
     Mockery context = new JUnit4Mockery();
     ArrayList<String> poblaciones;
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
        poblaciones= new ArrayList<String>(Arrays.asList("Valencia", "Alicante","Castellon"));
    }
    
    @After
    public void tearDown() {
    }

    
   
    @Test
    public void testListarPoblacionesConCine() {
       
        
        
         final Provincia p = context.mock(Provincia.class);

        context.checking(new Expectations() {
            {
                oneOf(p).ListarPoblaciones();
                will(returnValue(poblaciones));
            }
        });
       
        assertEquals(poblaciones.size(), 3);
        // int basura=currency.getPesetavalue(166);
    }

    

    
}
