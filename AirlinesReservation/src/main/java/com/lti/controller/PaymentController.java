package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.PaymentDetail;
import com.lti.repository.GenericRepository;

@RestController
public class PaymentController {

	@Autowired
	private GenericRepository gr;
	
	@GetMapping( path = "/payment")
	public boolean addPayment(@RequestParam("amount") int amount ) {
		try {
		PaymentDetail pd = new PaymentDetail();
		pd.setCardNumber("1234567891234567");
		pd.setTransactionAmount(amount);
		gr.save(pd);
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
