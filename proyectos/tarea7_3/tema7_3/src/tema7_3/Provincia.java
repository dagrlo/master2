
package tema7_3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Provincia {
    
    private Connection conexion;
    private Conexion db;
    private Statement stat;
    
    public Provincia(){
        db=new Conexion();
        conexion=db.conecta();
        try {
            stat=conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Provincia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> ListarPoblaciones() throws SQLException{
            ResultSet r=db.consultar(conexion, "select * from poblacion", stat);
            ArrayList<String> res=new ArrayList<String>();
            while(r.next()){
                res.add(r.getString("nombre"));
            }
        return res;
    }
    
    public void addPoblacion (String poblacion){
        
    }
    
}

