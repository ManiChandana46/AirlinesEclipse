package com.lti.repository;

import com.lti.entity.CustomerDetail;

public interface RegisterRepository {

	void addRegistration(CustomerDetail newRegister);

	boolean isCustomerPresent(String email);

}