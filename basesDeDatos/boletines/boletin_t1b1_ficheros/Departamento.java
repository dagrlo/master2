import java.io.Serializable;

public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idDepartamento;
    private String nombre;
    private String manager;
    private String administrador;

    public Departamento() {
        super();
        this.administrador = "";
        this.idDepartamento = "";
        this.manager = "";
        this.nombre = "";

    }
    public Departamento(String administrador, String idDepartamento,
            String manager, String nombre) {
        super();
        this.administrador = administrador;
        this.idDepartamento = idDepartamento;
        this.manager = manager;
        this.nombre = nombre;
    }
    public String getIdDepartamento() {
        return idDepartamento;
    }
    public String getNombre() {
        return nombre;
    }
    public String getManager() {
        return manager;
    }
    public String getAdministrador() {
        return administrador;
    }
    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setManager(String manager) {
        this.manager = manager;
    }
    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }
}
