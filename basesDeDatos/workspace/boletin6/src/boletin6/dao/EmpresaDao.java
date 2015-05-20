package boletin6.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import boletin6.entities.Empresa;

public class EmpresaDao<K, E> extends ClientesDao<Integer,Empresa>{
	
		
		public EmpresaDao(EntityManager em){
			super (em);
		}
		
		public List<Empresa> getAllEmpresas(){
			TypedQuery<Empresa> query=em.createNamedQuery("Empresa.findAll",Empresa.class);
			return query.getResultList();
		}	
}
