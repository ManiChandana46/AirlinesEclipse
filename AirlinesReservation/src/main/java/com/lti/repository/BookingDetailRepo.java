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

	public void deleteBooking(int bookingId) {
		// FlightBookingDetail cancel =
		// genericRepository.fetchById(FlightBookingDetail.class,bookingId);
		entityManager.createQuery("delete from PassengerDetail p where p.flightBookingDetail.bookId= :bookId")
				.setParameter("bookId", bookingId).executeUpdate();

		entityManager.createQuery("delete from PaymentDetail p where p.flightBookingDetail.bookId= :bookId")
				.setParameter("bookId", bookingId).executeUpdate();

		entityManager.createQuery("delete from FlightBookingDetail b where b.bookId= :bookId")
				.setParameter("bookId", bookingId).executeUpdate();
	}

	public void deleteReturnBooking(int returnId) {
		// ReturnDetail cancel =
		// genericRepository.fetchById(ReturnDetail.class,returnId);

		entityManager.createQuery("delete from ReturnDetail r where r.returnId= :returnId")
				.setParameter("returnId", returnId).executeUpdate();
	}

	public void cancelBooking(int returnId) {
		entityManager.createQuery(
				"update FlightBookingDetail b set b.returnDetail.returnId= null where b.returnDetail.returnId= :returnId")
				.setParameter("returnId", returnId).executeUpdate();
	}

}
