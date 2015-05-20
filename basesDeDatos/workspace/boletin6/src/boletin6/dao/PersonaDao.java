package boletin6.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import boletin6.entities.Empresa;
import boletin6.entities.Persona;

public class PersonaDao<K, E> extends ClientesDao<Integer,Persona>{

	public PersonaDao(EntityManager em) {
		super(em);
	}
	
	public List<Persona> getAllPersonas(){
		TypedQuery<Persona> query=em.createNamedQuery("Persona.findAll",Persona.class);
		return query.getResultList();
	}	

}
