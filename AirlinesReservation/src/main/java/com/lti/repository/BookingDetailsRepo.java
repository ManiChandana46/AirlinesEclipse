package com.lti.repository;

import java.util.List;

import com.lti.entity.FlightBookingDetail;
import com.lti.entity.ReturnDetail;

public interface BookingDetailsRepo {

	FlightBookingDetail fetchBooking(int bookingId);

	ReturnDetail fetchReturnDetails(int returnId);

	int isReturnAvailable(int bookingId);

	void deleteBooking(int bookingId);

	void deleteReturnBooking(int returnId);

	void cancelBooking(int returnId);

	List<Integer> fetchBookingId(int customerId);

	boolean isBookingAvailable(int customerId);

}