package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.ReturnDetail;
import com.lti.entity.FlightBookingDetail;

@Repository
public class BookingDetailRepo {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private GenericRepository genericRepository;

	public FlightBookingDetail fetchBooking(int bookingId) {
		return genericRepository.fetchById(FlightBookingDetail.class, bookingId);
	}

	public ReturnDetail fetchReturnDetails(int returnId) {
		return genericRepository.fetchById(ReturnDetail.class, returnId);
	}

	public int isReturnAvailable(int bookingId) {
		FlightBookingDetail flightBookingDetail = genericRepository.fetchById(FlightBookingDetail.class, bookingId);
		if (flightBookingDetail.getReturnDetail() != null) {
			return (Integer) entityManager
					.createQuery(
							"select fb.returnDetail.returnId from FlightBookingDetail fb where fb.bookId= :bookingId")
					.setParameter("bookingId", bookingId).getSingleResult();
		}
		return 0;
	}

}
