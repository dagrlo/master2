package boletin6.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the actividades database table.
 * 
 */
@Entity
@Table(name="actividades")
@NamedQuery(name="Actividad.findAll", query="SELECT a FROM Actividad a")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idActividad;

	private String actividad;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="actividade", fetch=FetchType.EAGER)
	private List<Empresa> empresas;

	public Actividad() {
	}

	public String getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(String idActividad) {
		this.idActividad = idActividad;
	}

	public String getActividad() {
		return this.actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public List<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa addEmpresa(Empresa empresa) {
		getEmpresas().add(empresa);
		empresa.setActividade(this);

		return empresa;
	}

	public Empresa removeEmpresa(Empresa empresa) {
		getEmpresas().remove(empresa);
		empresa.setActividade(null);

		return empresa;
	}

}