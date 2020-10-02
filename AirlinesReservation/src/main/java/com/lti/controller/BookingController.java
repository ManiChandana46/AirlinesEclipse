package com.lti.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BookedTicketSearch;
import com.lti.dto.BookingDetail;
import com.lti.dto.ReturnDetail;
import com.lti.service.BookingDetailService;

@RestController
@CrossOrigin
public class BookingController {

	@Autowired
	private BookingDetailService service;

	@PostMapping(path = "/searchbooking")
	public Object searchTicket(@RequestBody BookedTicketSearch bookedTicketSearch) {
		// TODO Auto-generated method stub

		String[] str = new String[30];
		str = service.searchBooking(bookedTicketSearch.getBookingId());
		BookingDetail obj1 = new BookingDetail();
		ReturnDetail obj2 = new ReturnDetail();

		obj1.setBookingId(Integer.parseInt(str[0]));
		obj1.setNumberOfSeats(Integer.parseInt(str[1]));
		obj1.setClassType(str[2]);
		
		obj1.setFlightSeatsSelected(str[3]);
		obj1.setDateOfJourney(LocalDate.parse(str[4]));
		obj1.setEndTime(str[5]);
		obj1.setStartTime(str[6]);
		obj1.setPrice(Double.parseDouble(str[7]));
		obj1.setFrom(str[8]);
		obj1.setTo(str[9]);
		obj1.setDuration(str[10]);
		obj1.setDateOfBooking(LocalDateTime.parse(str[11]));

		obj2.setReturnId(Integer.parseInt(str[12]));
		obj2.setNumberOfSeats(Integer.parseInt(str[13]));
		obj2.setClassType(str[14]);
		obj2.setFlightSeatsSelected(str[15]);
		obj2.setDateOfJourney(LocalDate.parse(str[16]));
		obj2.setEndTime(str[17]);
		obj2.setStartTime(str[18]);
		obj2.setPrice(Double.parseDouble(str[19]));
		obj2.setFrom(str[20]);
		obj2.setTo(str[21]);
		obj1.setReturnDetail(obj2);

		return obj1;
	}

}
