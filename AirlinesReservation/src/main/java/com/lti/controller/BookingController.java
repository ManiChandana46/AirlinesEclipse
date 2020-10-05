package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BookedTicketSearch;

import com.lti.dto.SearchBookingDto;
import com.lti.dto.Status;
import com.lti.exception.AirlinesServiceException;
import com.lti.service.BookingDetailService;

@RestController
@CrossOrigin
public class BookingController {

	@Autowired
	private BookingDetailService service;

	@PostMapping(path = "/searchbooking")
	public SearchBookingDto searchBooking(@RequestBody BookedTicketSearch bookedTicketSearch) {
		return service.fetchBookingDetails(bookedTicketSearch.getBookingId());
	}

	@PostMapping(path = "/cancelbooking")
	public Status cancelBooking(@RequestBody BookedTicketSearch bookedTicketSearch) {
		try {

			return service.cancelBooking(bookedTicketSearch.getBookingId());

		} catch (AirlinesServiceException e) {
			Status status = new Status();
			status.setStatusMessage(e.getMessage());
			status.setStatus(false);
			return status;
		}
	}
	
	@PostMapping(path = "/cancelreturnbooking")
	public Status cancelReturnBooking(@RequestBody BookedTicketSearch bookedTicketSearch) {
		try {

			return service.cancelReturnBooking(bookedTicketSearch.getBookingId());

		} catch (AirlinesServiceException e) {
			Status status = new Status();
			status.setStatusMessage(e.getMessage());
			status.setStatus(false);
			return status;
		}
	}
	
	
}
