package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.PaymentDto;
import com.lti.dto.PaymentStatus;

import com.lti.exception.AirlinesServiceException;
import com.lti.service.PaymentService;

@RestController
@CrossOrigin
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PaymentStatus paymentStatus;

	@PostMapping(path = "/payment")
	public PaymentStatus addPayment(@RequestBody PaymentDto paymentDto) {
		try {

			return paymentService.flightBooking(paymentDto);

		} catch (AirlinesServiceException e) {

			paymentStatus.setStatus(false);
			paymentStatus.setStatusMessage("Payment Failed");
			paymentStatus.setTransactionId(0);
			paymentStatus.setBookingId(0);
			paymentStatus.setReturnId(0);

			return paymentStatus;
		}

	}
}
