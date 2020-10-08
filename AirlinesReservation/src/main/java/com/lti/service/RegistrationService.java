package com.lti.service;

import com.lti.entity.CustomerDetail;

public interface RegistrationService {

	void addRegistration(CustomerDetail newRegister);

	boolean customerCheck(String email);

}