package boletin6.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

public class ClientesDao<K, E> implements Dao<K,E>{
	protected Class<E> entityClass;
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	public ClientesDao(EntityManager em) {
	 ParameterizedType genericSuperclass = (ParameterizedType)getClass().getGenericSuperclass();
	 this.entityClass = (Class<E>)genericSuperclass.getActualTypeArguments()[1];
	 this.em = em;
	}
	
	@Override
	public E findById(K id) {
	 E entity;
	 entity = em.find(entityClass, id);
	 return entity;
	}
	
	@Override
	public void persist(E entity) {
	 em.persist(entity);
	 em.flush();
	}
	
	@Override
	public void remove(E entity) {
	 em.remove(entity);
	 em.flush();
	}

}
