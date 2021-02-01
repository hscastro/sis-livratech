package br.ce.hscastro.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**Projeto Livraria ABC
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 29/01/2021 
 */

public abstract class AbstractDao<T, PK extends Serializable> {

	@SuppressWarnings("unchecked")
	private final Class<T> entityClass = 
			(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];
	
	@PersistenceContext
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void save(T t) {
		entityManager.persist(t);
	}

	public void update(T t) {
		entityManager.merge(t);
	}
	
	public void delete(PK id) {
		entityManager.remove(entityManager.getReference(entityClass, id));
	}	
	
	public T findById(PK id) {
		
		return entityManager.find(entityClass, id);
	}
	
	public List<T> findAll(){
		
		return entityManager.createQuery("from "+entityClass.getName(), entityClass)
				.getResultList();
	}
	
	public List<T> createQuery(String jpql, Object... params){
		
		TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
		
		for(int i = 0; i < params.length; i++) {
			query.setParameter(i+1, params[i]);
		}
		
		return query.getResultList();
		
	}	
	
}
