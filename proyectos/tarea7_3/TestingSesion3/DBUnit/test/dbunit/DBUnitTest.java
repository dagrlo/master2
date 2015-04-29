package dbunit;
//ejemplos: http://www.marcphilipp.de/blog/2012/03/13/database-tests-with-dbunit-part-1/
//Ejemplo 2: http://www.notodocodigo.com/blog/uso-de-dbunit/
//para crear un dataset desde la BDA:   http://micro-howto.blogspot.com.es/2010/08/dbunit-lo-hace-facil.html
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date; 
import org.dbunit.assertion.DbUnitAssert;

//JUnit
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
//DBUnit

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.*;
import org.dbunit.dataset.xml.*;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;

public class DBUnitTest {

 
  @BeforeClass
  public static void setUp() throws Exception {
    setUpDatabase();
}
 @Before
 public void setstate(){
   
 }
public static void setUpDatabase() throws Exception {
    // Inicializa tu base de datos aquí
  
    Connection jdbcConnection = DriverManager.getConnection(
"jdbc:mysql://localhost/testdbunit", "udb", "pudb");
  IDatabaseConnection  connection = new DatabaseConnection(jdbcConnection);
 
// inicializa tu dataset aquí. Coge dataset y lo carga en la BDA
    IDataSet dataSet = new FlatXmlDataSet(new File("UsersDataset2.xml"));
    try{
     DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
  }finally {
        connection.close();
    }
}

   
   @Test
  public void TestFind_per_name() throws Exception {
      
     
     
      DBUnit repository = new DBUnit();
      Person person_dataset = repository.find_per_name("Jose");

      assertEquals("Lopez", person_dataset.GetLastName());
  }
   
   @Test
  public void TestaddPerson() throws Exception {
      
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
String dateInString = "07/06/2013";
Date fecha = formatter.parse(dateInString);
Person p = new Person(3,"Toni","Bella",fecha, true,8);
DBUnit BDA=new DBUnit();
BDA.add_person(p);   
     
 
 assertNotNull("La persona no se ha añadido",BDA.find_per_name("Toni"));
  }
   
   @Test
  public void TestDeletePerson() throws Exception {
      
DBUnit BDA=new DBUnit();
BDA.delete_person("Lopez");
      
 assertNull("La persona si que existe en la BDA", BDA.find_per_name("Ignacio"));
  }
   
   @Test
   public void CompararDataSets() throws Exception{
     DbUnitAssert dbAssert = new DbUnitAssert();
     IDataSet dataSet1 = new FlatXmlDataSet(new File("UsersDataset.xml"));
     IDataSet dataSet2 = new FlatXmlDataSet(new File("UsersDataset2.xml"));
     dbAssert.assertEquals(dataSet1,dataSet2);
   
       
   }
  

  
}
