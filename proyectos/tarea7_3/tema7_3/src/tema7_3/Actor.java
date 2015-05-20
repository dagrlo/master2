/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema7_3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actor {

    private Connection conexion;
    private Conexion db;
    private Statement stat;
    
    private int id;
    private String nombre;
    private String apellidos;

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    Actor(){
        
    }
   

    Actor(int id) {
        this.id=id;
        db = new Conexion();
        conexion = db.conecta();
        try {
            stat = conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Provincia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addPelicula(Pelicula pelicula) {
    }

    public void deletePelicula(Pelicula pelicula) {

    }

    public ArrayList<String> getPeliculas() throws SQLException {
         ResultSet r=db.consultar(conexion, "select * from pelicula where id_actor="+this.id, stat);
            ArrayList<String> res=new ArrayList<String>();
            while(r.next()){
                res.add(r.getString("titulo"));
            }
        return res;
    }
}
