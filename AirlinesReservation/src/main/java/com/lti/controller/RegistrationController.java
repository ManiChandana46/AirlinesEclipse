package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.EmailCustomerCheck;
import com.lti.dto.Status;
import com.lti.entity.CustomerDetail;
import com.lti.exception.AirlinesServiceException;

import com.lti.service.RegistrationService;
@RestController
@CrossOrigin
public class RegistrationController {
	@Autowired
	private RegistrationService service;
	@PostMapping(path="/addregistration")
	public Status addRegistration(@RequestBody CustomerDetail newRegister) {
		try {
			Status status = new Status();
			if(service.customerCheck(newRegister.getCustomerEmail())) {
				service.addRegistration(newRegister);
				
				status.setStatusMessage("Registeration done");
				status.setStatus(true);
				return status;
			}
			else {
				status.setStatusMessage("already a registered customer");
				status.setStatus(true);
				return status;
			}
		} 
		catch (AirlinesServiceException e) {
			Status status = new Status();
			status.setStatusMessage(e.getMessage());
			status.setStatus(false);
			return status;
		}
	}
	@PostMapping(path="/checkregistration")
	public Status checkRegistration(@RequestBody EmailCustomerCheck check) {
		try {
			if(service.customerCheck(check.email)) {
				Status status = new Status();
				
				status.setStatus(true);
				return status;
			}
			else {
				Status status=new Status();
				status.setStatus(false);
				return status;
			}
		} 
		catch (AirlinesServiceException e) {
			Status status = new Status();
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
	

}
