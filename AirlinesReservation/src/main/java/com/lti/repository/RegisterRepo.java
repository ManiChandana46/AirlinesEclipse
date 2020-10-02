package com.lti.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.CustomerDetail;

@Repository
public class RegisterRepo {
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public void addRegistration(CustomerDetail newRegister) {
		entityManager.persist(newRegister);
	}


}
