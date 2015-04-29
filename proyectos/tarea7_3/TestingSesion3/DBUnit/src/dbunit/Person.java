/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbunit;

import java.util.Date;


/**
 *
 * @author jopana
 */
public class Person {
  private  String first_name;
   private String last_name;
  private  int id;
  private  Date date_created;
  private   boolean is_admin;
 private    int num_points;

    public String GetName(){
        return first_name;
        
    }
    public String GetLastName(){
        return last_name;
        
    }
      public int GetNumPoints(){
        return num_points;
        
    }
        public int GetId(){
        return id;
        
    }
         public Date GetDate(){
        return date_created;
        
    }
    public boolean GetIsAdmin(){
        return is_admin;
        
    }
   public Person(int identificador, String name, String surname, Date created, boolean admin, int points)  {
       
       id=identificador;
       first_name=name;
       last_name=surname;
       date_created=created;
       is_admin=admin;
       num_points=points;
   }
    public Person()  {
             
   }
    
    
        
    
}
