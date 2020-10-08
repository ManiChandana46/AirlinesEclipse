package com.lti.service;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.lti.entity.CustomerDetail;

@Service
public class EmailService {

	@Autowired
	private MailSender mailSender;

	public void sendEmailUponDeletion(int flightNumber, LocalDate date, CustomerDetail customer) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("do-not-reply@AirAviation.com");
		message.setTo(customer.getCustomerEmail());
		message.setSubject("Flight Cancelled");
		message.setText("Dear " + customer.getCustomerFirstName() + "\n" + "This is to inform you that Flight number "
				+ flightNumber + " on date " + date + " is cancelled due to some unaviodable reason." + "\n"
				+ "To make any alternative booking please visit our website");
		mailSender.send(message);

	}

	public int sendOtp(String mail) {

		Random rand = new Random();
		int x = rand.nextInt(1000);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("do-not-reply@AirAviation.com");
		message.setTo(mail);
		message.setSubject("Flight Cancelled");
		message.setText("Hi " + "\n" + "Your OTP to change Password is " + x);
		mailSender.send(message);

		return x;
	}

}
