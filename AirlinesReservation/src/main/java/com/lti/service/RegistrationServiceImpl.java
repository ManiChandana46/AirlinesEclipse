package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.CustomerDetail;
import com.lti.exception.AirlinesServiceException;

import com.lti.repository.RegisterRepository;

@Transactional
@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	private RegisterRepository repo;

	@Override
	public void addRegistration(CustomerDetail newRegister) {
		try {
			repo.addRegistration(newRegister);

		} catch (Exception e) {
			throw new AirlinesServiceException("User already registred!!");
		}
	}

	@Override
	public boolean customerCheck(String email) {
		try {
			return repo.isCustomerPresent(email);
		} catch (Exception e) {
			throw new AirlinesServiceException("customer is  already registered");
		}
	}

}
