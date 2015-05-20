package boletin6.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import boletin6.entities.Actividad;
import boletin6.entities.Persona;

public class ActividadDao<K, E> extends ClientesDao<Integer,Actividad>{

	public ActividadDao(EntityManager em) {
		super(em);	
	}
	
	public List<Actividad> getAllActividades(){
		TypedQuery<Actividad> query=em.createNamedQuery("Actividad.findAll",Actividad.class);
		return query.getResultList();
	}	

}
