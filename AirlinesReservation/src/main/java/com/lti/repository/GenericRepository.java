package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericRepository  {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public <T> T save(Object obj) {
		@SuppressWarnings("unchecked")
		T updatedObj=(T) entityManager.merge(obj);
		return updatedObj;
	}
	
	@Transactional
	public <T> T fetchById(Class<T> clazz,Object id){
		T obj = null;
		obj=entityManager.find(clazz, id); 
		return obj;
	}
	
}
