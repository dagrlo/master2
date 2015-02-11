import java.text.SimpleDateFormat;
import java.io.*;

public class SerialReader {
    public static void main(String[] args) {
    	FileInputStream fin = null;
        ObjectInputStream oin = null;

        try {
        	fin = new FileInputStream("empleado.ser");
            oin = new ObjectInputStream(fin);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            Empleado empleadoGuardado = (Empleado)oin.readObject();
            System.out.println(empleadoGuardado);
            System.out.println(" Departamento: " + empleadoGuardado.getDepartamento());
            System.out.println("       Puesto: " + empleadoGuardado.getPuesto() + 
            		", Antiguedad: " + formatter.format(empleadoGuardado.getFechaContrato()));
            System.out.println("  Nivel Educ.: " + empleadoGuardado.getNivelEducacion());
            double total = empleadoGuardado.getSueldo() + empleadoGuardado.getComplemento();
            System.out.println("       Sueldo: " + empleadoGuardado.getSueldo() + 
            		", Complemento: " + empleadoGuardado.getComplemento() + 
            		", Total: " + total);
            }
        catch (Exception e) {
        	e.printStackTrace();
        }
        finally {
        	try { if (oin != null) oin.close(); }
        	catch (IOException e) {}
        	try { if (fin != null) fin.close(); }
        	catch (IOException e) {}
        }
	}
}
