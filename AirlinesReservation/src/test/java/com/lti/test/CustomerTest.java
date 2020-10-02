package com.lti.test;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.entity.CustomerDetail;
import com.lti.entity.PaymentDetail;
import com.lti.repository.GenericRepository;

public class CustomerTest {
	
	//@Autowired
	//private GenericRepository genericRepository;
	
	/*@Test
	public void insertData() {
		CustomerDetail customerDetail = new CustomerDetail();
		customerDetail.setCustomerFirstName("Sayan");
		customerDetail.setCustomerLastName("Mitra");
		customerDetail.setCustomerEmail("smitra737@gmail.com");
		customerDetail.setCustomerPassword("12345");
		customerDetail.setCustomerPhoneNo("8582967302");
		customerDetail.setCustomerDateOfBirth(LocalDate.of(1998, 03, 10));
		genericRepository.save(customerDetail);
	}*/
	
	@Test
	public void addPayment() {
		PaymentDetail pd = new PaymentDetail();
		pd.setCardNumber("1234567891234567");
		pd.setPaymentType("Debit Card");
		pd.setTransactionAmount(10934.40);
		pd.setTransactionTime(LocalDateTime.now());
		//pd.setFlightBookingDetail(null);
		
		GenericRepository gr = new GenericRepository();
		gr.save(pd);
	}

}
