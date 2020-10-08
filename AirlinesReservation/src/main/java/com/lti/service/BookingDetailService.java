package com.lti.service;

import java.util.List;

import com.lti.dto.SearchBookingDto;
import com.lti.dto.Status;

public interface BookingDetailService {

	SearchBookingDto fetchBookingDetails(int bookingId);

	Status cancelBooking(int bookingId);

	Status cancelReturnBooking(int bookingId);

	List<SearchBookingDto> displayBooking(int customerId);

}