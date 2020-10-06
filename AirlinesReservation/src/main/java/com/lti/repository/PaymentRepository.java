package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.dto.PassengerDto;
import com.lti.entity.CustomerDetail;
import com.lti.entity.FlightBookingDetail;
import com.lti.entity.FlightSchedule;
import com.lti.entity.PassengerDetail;
import com.lti.entity.PaymentDetail;
import com.lti.entity.ReturnDetail;
import com.lti.entity.SeatDetail;

@Repository
public class PaymentRepository {

	@Autowired
	private GenericRepository genericRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	public ReturnDetail addReturnDetails(ReturnDetail returnDetail) {

		return genericRepository.save(returnDetail);

	}

	public FlightBookingDetail addFlightBookingDetails(FlightBookingDetail flightBookingDetailDetail) {

		return genericRepository.save(flightBookingDetailDetail);

	}

	public PaymentDetail addPayment(PaymentDetail paymentDetail) {

		return genericRepository.save(paymentDetail);

	}

	public void addPassenger(PassengerDto passengerDto,int id,FlightBookingDetail flightBookingDetail) {
		SeatDetail seatDetail=(SeatDetail) entityManager.createQuery("select s from SeatDetail s where s.flightSchedule.scheduleId= :s and s.seatName= :sn")
					 .setParameter("sn", passengerDto.getSeatAlloted())
					 .setParameter("s", id)
					 .getSingleResult();
		PassengerDetail passengerDetail=new PassengerDetail();
		passengerDetail.setName(passengerDto.getName());
		passengerDetail.setGender(passengerDto.getGender());
		passengerDetail.setAge(passengerDto.getAge());
		passengerDetail.setSeatDetail(seatDetail);
		passengerDetail.setFlightBookingDetail(flightBookingDetail);
		genericRepository.save(passengerDetail);
	}

	public FlightSchedule fetchFlightSchedule(int scheduleId) {
		return genericRepository.fetchById(FlightSchedule.class, scheduleId);
	}

	public CustomerDetail fetchCustomer(int customerId) {
		return genericRepository.fetchById(CustomerDetail.class, customerId);
	}

	public void seatEntry(String s,int id){
		entityManager.createQuery("update SeatDetail s set s.status=true where s.flightSchedule.scheduleId= :si and s.seatName= :sn")
					 .setParameter("sn", s)
					 .setParameter("si", id)
					 .executeUpdate();
		
	}
}
