package com.lti.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.CustomerDetail;

@Repository
public class RegisterRepositoryImpl implements RegisterRepository {
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void addRegistration(CustomerDetail newRegister) {
		entityManager.persist(newRegister);
	}
	
	@Override
	public boolean isCustomerPresent(String email) {
		return (Long)
				entityManager
				.createQuery("select count(c.customerId) from CustomerDetail c where c.customerEmail= :em")
				.setParameter("em", email)
				.getSingleResult()==1 ? true:false;
	}


}
