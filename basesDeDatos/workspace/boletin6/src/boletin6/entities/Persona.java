package boletin6.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personas database table.
 * 
 */
@Entity
@Table(name="personas")
@DiscriminatorValue("P")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona extends Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	private String apellidos;

	public Persona() {
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}