package tema7_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Conexion {

    public Conexion() {

    }

    public Connection conecta() {
        Connection conn = null;
        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/cinedbunit";
            Class.forName(myDriver);
            conn =  DriverManager.getConnection(myUrl, "root", "12monos");
        } catch (Exception e) {
            System.err.println("Got an exception in connect! ");
            System.err.println(e.getMessage());
        }
        return conn;
    }

    public void cerrar(Statement st) {
        try {
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception in close! ");
            System.err.println(e.getMessage());
        }

    }

    public ResultSet consultar(Connection conn, String query, Statement st) {
        ResultSet rs = null;

        try {

            // execute the query, and get a java resultset
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.err.println("Got an exception in query! ");
            System.err.println(e.getMessage());
        }
        return rs;
    }

    public void ejecutar(String sentencia, Statement st) {
        try {
            st.executeUpdate(sentencia);
        } catch (Exception e) {
            System.err.println("Got an exception in ejecutar! ");
            System.err.println(e.getMessage());
        }

    }

}
