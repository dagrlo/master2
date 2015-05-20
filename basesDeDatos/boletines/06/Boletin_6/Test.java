package es.uv.clientes.test;

import java.util.Date;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.uv.clientes.model.Actividad;
import es.uv.clientes.model.Empresa;
import es.uv.clientes.model.Persona;

public class Test {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("clientes");
	private static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			// TODO: Leer y escribir datos en la base de datos
			tx.commit();
		}
		catch (Exception e) {
			System.out.println("Se ha producido una excepción:");
			System.out.println(e.getMessage());
			System.out.println("Transacción abortada.");
			tx.rollback();
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	
	private static Actividad getActividadByName(String nombreActividad) {
		TypedQuery<Actividad> query = em.createNamedQuery("Actividad.findAll", Actividad.class);
		Vector<Actividad> actividades = (Vector<Actividad>) query.getResultList();
		for (Actividad a : actividades) {
			if (a.getActividad().equalsIgnoreCase(nombreActividad)) {
				return a;
			}
		}
		return null; 
   }
}
