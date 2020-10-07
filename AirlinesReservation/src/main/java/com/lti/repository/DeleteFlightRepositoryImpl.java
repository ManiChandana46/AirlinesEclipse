package com.lti.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.FlightBookingDetail;

@Repository
public class DeleteFlightRepositoryImpl implements DeleteFlightRepository {

	@Autowired
	private GenericRepository genericRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public int flightIdByFlightNumber(int flightNumber) {
		
		return (Integer) entityManager
		.createQuery("select f.flightId from FlightDetail f where f.flightNumber= :flightNumber")
		.setParameter("flightNumber", flightNumber)
		.getSingleResult();
	}
	
	@Override
	public int scheduleIdByFlightIdAndTravelDate(int flightId , LocalDate travelDate) {
		return (Integer) entityManager
						 .createQuery("select s.scheduleId from FlightSchedule s where s.flightDetail.flightId= :flightId and s.dateOfTravel= :travelDate")
						 .setParameter("flightId", flightId)
						 .setParameter("travelDate", travelDate)
						 .getSingleResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> listOfBookIdByScheduleId(int scheduleId) {
		
		return  new ArrayList<Integer>
					(entityManager
					.createQuery("select b.bookId from FlightBookingDetail b where b.flightSchedule.scheduleId= :scheduleId")
					.setParameter("scheduleId", scheduleId)
					.getResultList());		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> listOfReturnIdByScheduleId(int scheduleId) {
		
		return  new ArrayList<Integer>
					(entityManager
					.createQuery("select r.returnId from ReturnDetail r where r.flightSchedule.scheduleId= :scheduleId")
					.setParameter("scheduleId", scheduleId)
					.getResultList());		
	}
	
	@Override
	public void refereneceDeletionOfReturnIdFromBookTable(int returnId) {
		entityManager
		.createQuery("update FlightBookingDetail b set b.returnDetail.returnId= null where b.returnDetail.returnId= :returnId")
		.setParameter("returnId", returnId)
		.executeUpdate();
	}
	
	@Override
	public int bookIdByReturnId(int returnId) {
		return (Integer) entityManager
						.createQuery("select b.bookId from FlightBookingDetail b where b.returnDetail.returnId= :returnId")
						.setParameter("returnId", returnId)
						.getSingleResult();
	}
	
	@Override
	public int customerIdByBookId(int bookId) {
		return (Integer) entityManager
			             .createQuery("select b.customerDetail.customerId from FlightBookingDetail b where b.bookId= :bookId")
			             .setParameter("bookId", bookId)
			             .getSingleResult();		
	}
	
	@Override
	public int isReturnPresent(int bookId) {
		FlightBookingDetail flightBookingDetail = genericRepository.fetchById(FlightBookingDetail.class, bookId);
		if(flightBookingDetail.getReturnDetail() != null) {
			return (Integer) entityManager
							 .createQuery("select fb.returnDetail.returnId from FlightBookingDetail fb where fb.bookId= :bookId")
							 .setParameter("bookId", bookId)
							 .getSingleResult();
		}
		return 0;
	}
	
	@Override
	public void deleteReturnDetailByReturnId(int returnId) {
		entityManager
		.createQuery("delete from ReturnDetail r where r.returnId= :returnId")
		.setParameter("returnId", returnId)
		.executeUpdate();
	}
	
	@Override
	public void deletePassengerByBookId(int bookId) {
		entityManager
		.createQuery("delete from PassengerDetail p where p.flightBookingDetail.bookId= :bookId")
		.setParameter("bookId", bookId)
		.executeUpdate();
	}
	
	@Override
	public void deletePaymentByBookId(int bookId) {
		entityManager
		.createQuery("delete from PaymentDetail p where p.flightBookingDetail.bookId= :bookId")
		.setParameter("bookId", bookId)
		.executeUpdate();
	}
	
	@Override
	public void deleteBookingByBookId(int bookId) {
		entityManager
		.createQuery("delete from FlightBookingDetail f where f.bookId= :bookId")
		.setParameter("bookId", bookId)
		.executeUpdate();
	}
	
	@Override
	public void deleteSeatDetailByScheduleId(int scheduleId) {
		entityManager
		.createQuery("delete from SeatDetail s where s.flightSchedule.scheduleId= :scheduleId")
		.setParameter("scheduleId", scheduleId)
		.executeUpdate();
	}
	
	@Override
	public void deleteFlightScheduleByFlightIdAndTravelDate(int flightId , LocalDate travelDate) {
		 entityManager
		.createQuery("delete from FlightSchedule s where s.flightDetail.flightId= :flightId and s.dateOfTravel= :travelDate")
		.setParameter("flightId", flightId)
		.setParameter("travelDate", travelDate)
		.executeUpdate();
	}
	
}
