package com.lti.repository;

import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.CustomerDetail;

public interface RegisterRepository {

	void addRegistration(CustomerDetail newRegister);

	boolean isCustomerPresent(String email);

}