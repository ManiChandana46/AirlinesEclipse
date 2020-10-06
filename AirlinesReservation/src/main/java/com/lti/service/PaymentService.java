package com.lti.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.PassengerDto;
import com.lti.dto.PaymentDto;
import com.lti.dto.PaymentStatus;
import com.lti.entity.FlightBookingDetail;
import com.lti.entity.PassengerDetail;
import com.lti.entity.PaymentDetail;
import com.lti.entity.ReturnDetail;
import com.lti.exception.AirlinesServiceException;
import com.lti.repository.PaymentRepository;

@Service
@Transactional
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private PaymentStatus paymentStatus;

	public PaymentStatus flightBooking(PaymentDto paymentDto) {

		ReturnDetail returnDetail;
		FlightBookingDetail flightBookingDetail;

		try {

			if (paymentDto.isReturnStatus()) {

				returnDetail = new ReturnDetail();

				returnDetail.setNoOfSeats(paymentDto.getReturnNoOfSeats());
				returnDetail.setSeatSelected(paymentDto.getReturnSeatSelected());
				returnDetail.setReturnTravelDate(paymentDto.getReturnTravelDate());
				returnDetail.setReturnClass(paymentDto.getReturnClass());
				returnDetail.setFlightSchedule(paymentRepository.fetchFlightSchedule(paymentDto.getReturnScheduleId()));

				returnDetail = paymentRepository.addReturnDetails(returnDetail);

				flightBookingDetail = new FlightBookingDetail();

				flightBookingDetail.setNoOfSeats(paymentDto.getNoOfSeats());
				flightBookingDetail.setFlightClass(paymentDto.getFlightClass());
				flightBookingDetail.setSeatSelected(paymentDto.getSeatSelected());
				flightBookingDetail.setTravelDate(paymentDto.getTravelDate());
				flightBookingDetail.setReturnDetail(returnDetail);
				flightBookingDetail
						.setFlightSchedule(paymentRepository.fetchFlightSchedule(paymentDto.getScheduleId()));
				flightBookingDetail.setCustomerDetail(paymentRepository.fetchCustomer(paymentDto.getCustomerId()));

				flightBookingDetail = paymentRepository.addFlightBookingDetails(flightBookingDetail);

			} else {

				flightBookingDetail = new FlightBookingDetail();

				flightBookingDetail.setNoOfSeats(paymentDto.getNoOfSeats());
				flightBookingDetail.setFlightClass(paymentDto.getFlightClass());
				flightBookingDetail.setSeatSelected(paymentDto.getSeatSelected());
				flightBookingDetail.setTravelDate(paymentDto.getTravelDate());
				flightBookingDetail.setReturnDetail(null);
				flightBookingDetail
						.setFlightSchedule(paymentRepository.fetchFlightSchedule(paymentDto.getScheduleId()));
				flightBookingDetail.setCustomerDetail(paymentRepository.fetchCustomer(paymentDto.getCustomerId()));

				flightBookingDetail = paymentRepository.addFlightBookingDetails(flightBookingDetail);

			}

			PaymentDetail paymentDetail = new PaymentDetail();
			paymentDetail.setCardNumber(paymentDto.getCardNumber());
			paymentDetail.setPaymentType(paymentDto.getPaymentType());
			paymentDetail.setTransactionAmount(paymentDto.getTransactionAmount());
			paymentDetail.setTransactionTime(LocalDateTime.now());
			paymentDetail.setFlightBookingDetail(flightBookingDetail);

			paymentDetail = paymentRepository.addPayment(paymentDetail);

			List<PassengerDto> passengers = paymentDto.getPassengerDetails();

			for (PassengerDto passenger : passengers) {
				//passenger.setFlightBookingDetails(flightBookingDetail);
				paymentRepository.addPassenger(passenger,paymentDto.getScheduleId(),flightBookingDetail);
			}
			
			String seats=paymentDto.getSeatSelected();
			String seatNames[]=seats.split(",");
			for(String s:seatNames)
				paymentRepository.seatEntry(s,paymentDto.getScheduleId());
				

			paymentStatus.setStatus(true);
			paymentStatus.setStatusMessage("Payment Succesfull");
			paymentStatus.setTransactionId(paymentDetail.getTransactionId());
			paymentStatus.setBookingId(flightBookingDetail.getBookId());

			return paymentStatus;

		} catch (Exception e) {
			throw new AirlinesServiceException("Payment Failed");

		}

	}

}
