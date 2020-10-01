package com.lti.service;

import com.lti.entity.CustomerDetail;

public interface LoginService {
	
	CustomerDetail login(String email, String password);

}