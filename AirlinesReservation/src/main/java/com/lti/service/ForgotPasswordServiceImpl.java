package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.CustomerDetail;
import com.lti.exception.AirlinesServiceException;
import com.lti.repository.GenericRepository;
import com.lti.repository.LoginRepository;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

	@Autowired
	private GenericRepository genericRepository;

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public void changePassword(String email, String password) {
		try {
			if (!loginRepository.isCustomerPresent(email)) {
				throw new AirlinesServiceException("Invalid Email Address");
			}

			CustomerDetail customer = loginRepository.findById(loginRepository.findByEmail(email));
			customer.setCustomerPassword(password);
			genericRepository.save(customer);
		} catch (EmptyResultDataAccessException e) {

			throw new AirlinesServiceException("Password change failed, please try again");

		}

	}

}
