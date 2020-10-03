package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.SearchBookingDto;
import com.lti.entity.FlightBookingDetail;
import com.lti.entity.ReturnDetail;
import com.lti.exception.AirlinesServiceException;
import com.lti.repository.BookingDetailRepo;

@Transactional
@Service
public class BookingDetailService {

	@Autowired
	private BookingDetailRepo bookingDetailRepo;

	@Autowired
	private SearchBookingDto searchBookingDto;

	public SearchBookingDto fetchBookingDetails(int bookingId) {

		try {

			FlightBookingDetail flightBookingDetail = bookingDetailRepo.fetchBooking(bookingId);
			searchBookingDto.setBookId(flightBookingDetail.getBookId());
			searchBookingDto.setNoOfSeats(flightBookingDetail.getNoOfSeats());
			searchBookingDto.setSeatSelected(flightBookingDetail.getSeatSelected());
			searchBookingDto.setFlightClass(flightBookingDetail.getFlightClass());
			searchBookingDto.setTravelDate(flightBookingDetail.getTravelDate());

			int returnId = bookingDetailRepo.isReturnAvailable(bookingId);
			if (returnId != 0) {
				ReturnDetail returnDetail = bookingDetailRepo.fetchReturnDetails(returnId);
				searchBookingDto.setReturnId(returnDetail.getReturnId());
				searchBookingDto.setReturnNoOfSeats(returnDetail.getNoOfSeats());
				searchBookingDto.setReturnSeatSelected(returnDetail.getSeatSelected());
				searchBookingDto.setReturnFlightClass(returnDetail.getReturnClass());
				searchBookingDto.setReturnTravelDate(returnDetail.getReturnTravelDate());

				return searchBookingDto;
			} else {
				searchBookingDto.setReturnId(0);
				searchBookingDto.setReturnNoOfSeats(0);
				searchBookingDto.setReturnSeatSelected(null);
				searchBookingDto.setReturnFlightClass(null);
				searchBookingDto.setReturnTravelDate(null);
			}
			return searchBookingDto;
		} catch (Exception e) {
			throw new AirlinesServiceException("Invalid Booking Id");
		}

	}

}
