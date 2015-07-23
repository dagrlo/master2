package boletin6.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import boletin6.entities.Cliente;
import boletin6.entities.Empresa;

public class ClienteDao extends ClientesDao<Integer,Cliente>{

	public ClienteDao(EntityManager em) {
		super(em); 
	}
	
	public List<Cliente> getAllEmpresas(){
		TypedQuery<Cliente> query=em.createNamedQuery("Cliente.findall",Cliente.class);
		return query.getResultList();
	}		

	
}