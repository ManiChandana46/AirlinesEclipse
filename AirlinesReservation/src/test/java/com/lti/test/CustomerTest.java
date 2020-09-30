package com.lti.test;


import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.entity.CustomerDetail;
import com.lti.repository.GenericRepository;

public class CustomerTest {
	
	@Autowired
	private GenericRepository genericRepository;
	
	@Test
	public void insertData() {
		CustomerDetail customerDetail = new CustomerDetail();
		customerDetail.setCustomerFirstName("Sayan");
		customerDetail.setCustomerLastName("Mitra");
		customerDetail.setCustomerEmail("smitra737@gmail.com");
		customerDetail.setCustomerPassword("12345");
		customerDetail.setCustomerPhoneNo("8582967302");
		customerDetail.setCustomerDateOfBirth(LocalDate.of(1998, 03, 10));
		genericRepository.save(customerDetail);
	}

}
