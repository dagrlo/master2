package dbunit;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.sql.DataSource;
import org.h2.jdbcx.JdbcDataSource;
import java.util.Date;

/**
 * A Java MySQL SELECT statement example.
 * Demonstrates the use of a SQL SELECT statement against a
 * MySQL database, called from a Java program.
 * 
 * Created by Alvin Alexander, http://devdaily.com
 */
public class DBUnit
{
  private static Vector personas=new Vector(20);

   
 public DBUnit (){
      
  }
    DBUnit(JdbcDataSource dataSource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
  public DBUnit (DataSource ds){
      
  }
   
 public Connection conectar(){
      // create our mysql database connection
     Connection conn=null;
     try{
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/testDBUnit";
      Class.forName(myDriver);
      conn = DriverManager.getConnection(myUrl, "root", "i71181");
     }
      catch (Exception e)
    {
      System.err.println("Got an exception in connect! ");
      System.err.println(e.getMessage());}
      return conn;
     
 }   
 public void cerrar(Statement st){
     try{
     st.close();
     }
      catch (Exception e)
    {
      System.err.println("Got an exception in close! ");
      System.err.println(e.getMessage());}
     
 }
 
 public ResultSet consultar (Connection conn, String query, Statement st){
     ResultSet rs=null;
    
     try
    {
        
      // execute the query, and get a java resultset
      rs = st.executeQuery(query);
    }
    catch (Exception e)
    {
      System.err.println("Got an exception in query! ");
      System.err.println(e.getMessage());}
     return rs;
     
 }
 public void ejecutar (String sentencia, Statement st){
     try{
     st.executeUpdate(sentencia);
     }catch (Exception e)
    {
      System.err.println("Got an exception in ejecutar! ");
      System.err.println(e.getMessage());}
     
 }
 
 public Person find_per_name(String name){
     int i;
      DBUnit BDA=new DBUnit();
      Connection conn;
       ResultSet rs;
       Person aux_persona;
       String nom_aux;
      
    try
    {    
      conn=BDA.conectar();
   
      String query = "SELECT * FROM users"; 
      Statement st = conn.createStatement();

      rs=BDA.consultar(conn, query,st);
     
      // iterate through the java resultset
      while (rs.next())
      {
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        Date dateCreated = rs.getDate("date_created");
        boolean isAdmin = rs.getBoolean("is_admin");
        int numPoints = rs.getInt("num_points");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateCreated);
                
        aux_persona=new Person(id,firstName,lastName,dateCreated,isAdmin,numPoints);
        personas.addElement(aux_persona);
                
        
      }
      BDA.cerrar(st);
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
          
     for (i=0; i<personas.size(); i++){
         nom_aux=((Person)(personas.elementAt(i))).GetName();
               if (nom_aux.compareTo(name)==0){
             return ((Person)(personas.elementAt(i)));
         }
                  }
     return null;
 }

 public void add_person (Person persona){
     int id, num_points;
     DBUnit BDA=new DBUnit();
     Connection conn;
     Person aux_persona;
     String first_name, last_name, date_string;
     boolean is_admin;
     Date date_created;
        
    try
    {    
   conn=BDA.conectar();
   id=persona.GetId();
   first_name=persona.GetName();
   last_name=persona.GetLastName();
   date_created=persona.GetDate();
   is_admin=persona.GetIsAdmin();
   num_points=persona.GetNumPoints();
   Statement st = conn.createStatement(); 
   Calendar calendar = Calendar.getInstance(); calendar.setTime(date_created);
   int dia= calendar.get(Calendar.DAY_OF_MONTH);
   int anyo = calendar.get(Calendar.YEAR);   
   int mes = calendar.get(Calendar.MONTH)+1;
   date_string=anyo+"-"+mes+"-"+dia;     
      
    String sentencia = "INSERT INTO users (id,first_name,last_name,date_created,is_admin,num_points) VALUES ("+id+",'"+first_name+"','"+last_name+"','"+date_string+"',"+is_admin+","+num_points+")"; 
    BDA.ejecutar(sentencia,st);
        
    aux_persona=new Person(id,first_name,last_name,date_created,is_admin,num_points);
    personas.addElement(aux_persona);     
    BDA.cerrar(st);
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }  
 }
 
 public void delete_person (String last_name){
    int i;
      DBUnit BDA=new DBUnit();
      Connection conn;
     String nom_aux;
    try
    {    
    conn=BDA.conectar();
    Statement st = conn.createStatement();            
    String sentencia = "DELETE FROM users WHERE last_name='"+last_name+"'"; 
    BDA.ejecutar(sentencia,st);
          
    for (i=0;i<personas.size();i++){
        nom_aux=((Person)(personas.elementAt(i))).GetLastName();
         if (nom_aux.compareTo(last_name)==0){
            personas.removeElementAt(i);
         } 
    }                
              
      BDA.cerrar(st);
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }            
 }
  public static void main(String[] args)
          
  {
      //crear ficheros de DataSet
      ExtractDataSet DS =new ExtractDataSet();
      
try{
     DS.CrearDataSet();
     /*
 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
String dateInString = "07/06/2013";
 Date fecha = formatter.parse(dateInString);
 Person p = new Person(4,"Toni","Bella",fecha, true,8);
 DBUnit BDA=new DBUnit();
 BDA.add_person(p);
 BDA.delete_person("Pepe");
 */
}
catch (Exception e) {
		e.printStackTrace();
	}
      
     
     
}
}