package com.lti.repository;

import com.lti.entity.CustomerDetail;

public interface LoginRepository {

	int findByEmailAndPassword(String email, String password);

	boolean isCustomerPresent(String email);

	CustomerDetail findById(int id);

	int findByEmail(String email);

}