import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SerialWriter {
	public static void main(String[] args) {
		FileOutputStream fout = null;
        ObjectOutputStream oout = null;

        try {
        	fout = new FileOutputStream("empleado.ser");
            oout = new ObjectOutputStream(fout);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            
            Empleado empleado = new Empleado("000041", "DAVID", "SORIANO SORIANO");
            empleado.setDepartamento("E21");
            Date fc =  formatter.parse("2007-12-08");
            empleado.setFechaContrato(fc);
            empleado.setPuesto("SLS");
            empleado.setNivelEducacion(8);
            empleado.setSueldo(29416.00);
            empleado.setComplemento(2241.00);
            
            oout.writeObject(empleado);
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        	try { if (oout != null) oout.close(); }
            catch (IOException e) {}
            try { if (fout != null) fout.close(); }
            catch (IOException e) {}
        }
	}
}
