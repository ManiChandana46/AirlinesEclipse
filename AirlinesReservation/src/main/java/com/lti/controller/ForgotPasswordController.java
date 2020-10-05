package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ForgotPassword;
import com.lti.dto.Status;
import com.lti.exception.AirlinesServiceException;
import com.lti.service.ForgotPasswordService;

@RestController
@CrossOrigin
public class ForgotPasswordController {

	@Autowired
	private ForgotPasswordService forgotPasswordService;

	@Autowired
	private Status status;

	@PostMapping("/forgotPassword")
	public Status changePassword(@RequestBody ForgotPassword forgotPassword) {

		try {
			forgotPasswordService.changePassword(forgotPassword.getEmail(), forgotPassword.getNewPassword());
			status.setStatus(true);
			status.setStatusMessage("Password Changes Succesfully");
			return status;
		} catch (AirlinesServiceException e) {
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
		}

	}

}
