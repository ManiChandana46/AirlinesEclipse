package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.CustomerDetail;
import com.lti.exception.LoginServiceException;
import com.lti.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public CustomerDetail login(String email, String password) {
		try {
			if (!loginRepository.isCustomerPresent(email)) {
				throw new LoginServiceException("Customer not registered");
			}
			return loginRepository.findById(loginRepository.findByEmailAndPassword(email, password));

		} catch (EmptyResultDataAccessException e) {
			throw new LoginServiceException("Invalid email/password");
		}

	}

}
