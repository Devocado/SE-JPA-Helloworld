package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceService {
	
	private final String persistenceUnit = "appPU";
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnit);
	
	private EntityManager em = factory.createEntityManager();
	
	public void createEntityManager() {
		em = factory.createEntityManager();
	}
	
	public void closeEntityManager() {
		em.close();
	}
	
	public <T> void persist(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	public <T> T find(Class<T> entityClass, Long id) {
		em.getTransaction().begin();
		T entity = em.find(entityClass, id);
		em.getTransaction().commit();
		return entity;
	}
	
	public <T> T update(T entity) {
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}
	
	public void delete(Object entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

}
