package sssi.tasi.capitulo4.dto;

import java.util.Date;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellidos;
    private int departamento;
    private Date fechaContrato;
    private String puesto;
    private short nivelEducacion;
    private double sueldo;
    private double complemento;

    public Empleado() {
        this.idEmpleado = 0;
        this.nombre = "";
        this.apellidos = "";
        this.departamento = 0;
        this.fechaContrato = new Date();
        this.puesto = "";
        this.nivelEducacion = 0;
        this.sueldo = 0.0;
        this.complemento = 0.0;
    }

    public Empleado(int idEmpleado, String nombre, String apellidos, int departamento, 
    		Date fechaContrato, String puesto, short nivelEducacion, 
    		double sueldo, double complemento) {
    	this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
        this.fechaContrato = fechaContrato;
        this.puesto = puesto;
        this.nivelEducacion = nivelEducacion;
        this.sueldo = sueldo;
        this.complemento = complemento;
    }
    // getters
    public int getIdEmpleado() {
        return idEmpleado;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
    	return apellidos;
    }
    public int getDepartamento() {
        return departamento;
    }
    public Date getFechaContrato() {
        return fechaContrato;
    }
    public String getPuesto() {
        return puesto;
    }
    public short getNivelEducacion() {
        return nivelEducacion;
    }
    public double getSueldo() {
        return sueldo;
    }
    public double getComplemento() {
        return complemento;
    }
    // setters
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
    	this.apellidos = apellidos;
    }
    public void setDepartamento(int departamento) {
    	this.departamento = departamento;
    }
    public void setFechaContrato(Date fechaContrato) {
    	this.fechaContrato = fechaContrato;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public void setNivelEducacion(short nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    public void setComplemento(double complemento) {
        this.complemento = complemento;
    }

    // Otras funciones de utilidad
    public String toString() {
        return "[" + idEmpleado + "] " + nombre + " " + apellidos;
    }
}
