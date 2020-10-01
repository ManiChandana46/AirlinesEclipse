package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.CustomerDetail;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CustomerDetail findById(int id) {
		return entityManager.find(CustomerDetail.class, id);
	}

	@Override
	public int findByEmailAndPassword(String email, String password) {
		return (Integer) entityManager.createQuery("select c.customerId from CustomerDetail c where c.customerEmail =:em and c.customerPassword =:pw")
				.setParameter("em", email).setParameter("pw", password).getSingleResult();
	}

	@Override
	public boolean isCustomerPresent(String email) {
		return (Long) entityManager.createQuery("select count(c.customerId) from CustomerDetail c where c.customerEmail = :em")
				.setParameter("em", email).getSingleResult() == 1 ? true : false;
	}

}
