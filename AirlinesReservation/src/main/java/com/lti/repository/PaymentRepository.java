package com.lti.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.CustomerDetail;
import com.lti.entity.FlightBookingDetail;
import com.lti.entity.FlightSchedule;
import com.lti.entity.PassengerDetail;
import com.lti.entity.PaymentDetail;
import com.lti.entity.ReturnDetail;

@Repository
public class PaymentRepository {

	@Autowired
	private GenericRepository genericRepository;

	public ReturnDetail addReturnDetails(ReturnDetail returnDetail) {

		return genericRepository.save(returnDetail);

	}

	public FlightBookingDetail addFlightBookingDetails(FlightBookingDetail flightBookingDetailDetail) {

		return genericRepository.save(flightBookingDetailDetail);

	}

	public PaymentDetail addPayment(PaymentDetail paymentDetail) {

		return genericRepository.save(paymentDetail);

	}

	public void addPassenger(PassengerDetail passengerDetail) {
		genericRepository.save(passengerDetail);
	}

	public FlightSchedule fetchFlightSchedule(int scheduleId) {
		return genericRepository.fetchById(FlightSchedule.class, scheduleId);
	}

	public CustomerDetail fetchCustomer(int customerId) {
		return genericRepository.fetchById(CustomerDetail.class, customerId);
	}

}
