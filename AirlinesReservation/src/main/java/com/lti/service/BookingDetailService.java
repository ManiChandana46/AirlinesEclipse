package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.lti.entity.FlightBookingDetail;
import com.lti.exception.AirlinesServiceException;
import com.lti.repository.BookingDeatailRepo;

@Transactional
@Service
public class BookingDetailService {
	@Autowired
	private BookingDeatailRepo repo;
	
	public String[] searchBooking(int bookingId) {
		
		try {
			/*int rId =repo.isReturnIdPresent(bookingId);
			if(rId==0) {*/
				return repo.searchBooking(bookingId);
			/*}
			else {
				return repo.searchReturnBooking(bookingId,rId);
			}*/
		} catch (Exception e) {
			throw new AirlinesServiceException("Invalid Ticket No!!");
		}
	}


}
