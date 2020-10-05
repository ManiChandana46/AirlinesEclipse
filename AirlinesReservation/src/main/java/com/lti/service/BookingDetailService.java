package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.SearchBookingDto;
import com.lti.dto.Status;
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
			//searchBookingDto.setDateOfBooking(flightBookingDetail.getPaymentDetail().getTransactionTime());
			//searchBookingDto.setPrice(flightBookingDetail.getPaymentDetail().getTransactionAmount());
			searchBookingDto.setEndTime(flightBookingDetail.getFlightSchedule().getArrivalTime());
			searchBookingDto.setStartTime(flightBookingDetail.getFlightSchedule().getDepartureTime());
			searchBookingDto.setTo(flightBookingDetail.getFlightSchedule().getFlightRoute().getCityTo());
			searchBookingDto.setFrom(flightBookingDetail.getFlightSchedule().getFlightRoute().getCityFrom());
			searchBookingDto.setDuration(flightBookingDetail.getFlightSchedule().getFlightRoute().getDuration());
			
			int returnId = bookingDetailRepo.isReturnAvailable(bookingId);
			if (returnId != 0) {
				ReturnDetail returnDetail = bookingDetailRepo.fetchReturnDetails(returnId);
				searchBookingDto.setReturnId(returnDetail.getReturnId());
				searchBookingDto.setReturnNoOfSeats(returnDetail.getNoOfSeats());
				searchBookingDto.setReturnSeatSelected(returnDetail.getSeatSelected());
				searchBookingDto.setReturnFlightClass(returnDetail.getReturnClass());
				searchBookingDto.setReturnTravelDate(returnDetail.getReturnTravelDate());
				//searchBookingDto.setReturndateOfBooking(returnDetail.getFlightBookingdetail().getPaymentDetail().getTransactionTime());
				searchBookingDto.setReturnTo(returnDetail.getFlightSchedule().getFlightRoute().getCityTo());
				searchBookingDto.setReturnFrom(returnDetail.getFlightSchedule().getFlightRoute().getCityFrom());
				searchBookingDto.setReturnDuration(returnDetail.getFlightSchedule().getFlightRoute().getDuration());
				searchBookingDto.setReturnEndTime(returnDetail.getFlightSchedule().getArrivalTime());
				searchBookingDto.setReturnStartTime(returnDetail.getFlightSchedule().getDepartureTime());
				
				

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
	public Status cancelBooking(int bookingId) {
		try {
			int returnId = bookingDetailRepo.isReturnAvailable(bookingId);
			if (returnId != 0) {
				bookingDetailRepo.deleteReturnBooking(returnId);
				bookingDetailRepo.deleteBooking(bookingId);
				Status status = new Status();
				status.setStatusMessage("Your booking and return Ticket has been cancelled and you will recieve refund within 90 working days");
				status.setStatus(true);
				return status;
				
				
			}
			else {
				bookingDetailRepo.deleteBooking(bookingId);
				Status status = new Status();
				status.setStatusMessage("your booking ticket has been cancelled and you will receive refund within 90 days thankyou");
				status.setStatus(true);
				return status;
			}
			
		}catch(Exception e) {
			throw new AirlinesServiceException("Invalid Booking Id");
		}
		
	}

}
