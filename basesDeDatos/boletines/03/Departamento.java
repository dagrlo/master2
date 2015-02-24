package sssi.tasi.capitulo4.dto;

public class Departamento {

    private int idDepartamento;
    private String nombre;
    private int manager;

    public Departamento() {
        this.idDepartamento = 0;
        this.manager = 0;
        this.nombre = "";
    }
    public Departamento(int idDepartamento,
            String nombre, int manager) {
        this.idDepartamento = idDepartamento;
        this.manager = manager;
        this.nombre = nombre;
    }
    public int getIdDepartamento() {
        return idDepartamento;
    }
    public String getNombre() {
        return nombre;
    }
    public int getManager() {
        return manager;
    }
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setManager(int manager) {
        this.manager = manager;
    }
}
