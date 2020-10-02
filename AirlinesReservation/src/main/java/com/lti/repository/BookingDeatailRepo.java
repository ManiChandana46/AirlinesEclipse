package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.ReturnDetail;
import com.lti.entity.FlightBookingDetail;

@Repository
public class BookingDeatailRepo {
	@Autowired
	private EntityManager entityManager;

	@Transactional
	public String[] searchBooking(int bookingId) {
		// TODO Auto-generated method stub
		FlightBookingDetail details = entityManager.find(FlightBookingDetail.class, bookingId);

		/*
		 * Date date1 = details.getDateOfJourney(); Date date2 =
		 * details.getBookingDate(); DateFormat dateFormat = new
		 * SimpleDateFormat("dd-MM-yyyy");
		 */

		String[] str = new String[15];
		str[0] = "" + details.getBookId(); // dateFormat.format(date2); //booking date
		str[1] = "" + details.getNoOfSeats(); // dateFormat.format(date1); //date of journey
		str[2] = "" + details.getFlightClass(); // ticketNo
		str[3] = "" + details.getSeatSelected();
		str[4] = "" + details.getTravelDate();
		str[5] = "" + details.getFlightSchedule().getArrivalTime();
		str[6] = "" + details.getFlightSchedule().getDepartureTime();
		str[7] = "" + details.getPaymentDetail().getTransactionAmount();
		str[8] = "" + details.getFlightSchedule().getFlightRoute().getCityFrom();
		str[9] = "" + details.getFlightSchedule().getFlightRoute().getCityTo();
		str[10] = "" + details.getFlightSchedule().getFlightRoute().getDuration();
		str[11] = "" + details.getPaymentDetail().getTransactionTime();

		return str;
	}

	public String[] searchReturnBooking(int bookingId, int returnDetail) {
		// TODO Auto-generated method stub
		ReturnDetail details = entityManager.find(ReturnDetail.class, returnDetail);

		FlightBookingDetail details1 = entityManager.find(FlightBookingDetail.class, bookingId);
		//details1.setReturnDetail(details);

		/*
		 * Date date1 = details.getDateOfJourney(); Date date2 =
		 * details.getBookingDate(); DateFormat dateFormat = new
		 * SimpleDateFormat("dd-MM-yyyy");
		 */
		//System.out.println(details.getReturnId());
		String[] str = new String[30];
		str[0] = "" + details1.getBookId(); // dateFormat.format(date2); //booking date
		str[1] = "" + details1.getNoOfSeats(); // dateFormat.format(date1); //date of journey
		str[2] = "" + details1.getFlightClass(); // ticketNo
		str[3] = "" + details1.getSeatSelected();
		str[4] = "" + details1.getTravelDate();
		str[5] = "" + details1.getFlightSchedule().getArrivalTime();
		str[6] = "" + details1.getFlightSchedule().getDepartureTime();
		str[7] = "" + details1.getPaymentDetail().getTransactionAmount();
		str[8] = "" + details1.getFlightSchedule().getFlightRoute().getCityFrom();
		str[9] = "" + details1.getFlightSchedule().getFlightRoute().getCityTo();
		str[10] = "" + details1.getFlightSchedule().getFlightRoute().getDuration();
		str[11] = "" + details1.getPaymentDetail().getTransactionTime();

		str[12] = "" + details.getReturnId();
		str[13] = "" + details.getNoOfSeats();
		str[14] = "" + details.getReturnClass();
		str[15] = "" + details.getSeatSelected();
		str[16] = "" + details.getReturnTravelDate();
		str[17] = "" + details.getFlightSchedule().getArrivalTime();
		str[18] = "" + details.getFlightSchedule().getDepartureTime();
		str[19] = "" + details.getFlightBookingdetail().getPaymentDetail().getTransactionAmount();
		str[20] = "" + details.getFlightSchedule().getFlightRoute().getCityFrom();
		str[21] = "" + details.getFlightSchedule().getFlightRoute().getCityTo();
		str[22] = "" + details.getFlightSchedule().getFlightRoute().getDuration();
		str[23] = "" + details.getFlightBookingdetail().getPaymentDetail().getTransactionTime();

		return str;

	}

	public int isReturnIdPresent(int bookingId) {
//		String jpql = "select b.returnDetail from FlightBookingDetail b where b.bookId= :book";
//		Query q = entityManager.createQuery(jpql);
		//ReturnDetail result = (ReturnDetail) q.setParameter("book", bookingId).getSingleResult();
		
		FlightBookingDetail d1 = entityManager.find(FlightBookingDetail.class, bookingId);
		ReturnDetail result = d1.getReturnDetail();
		
		if (result != null) {
			return result.getReturnId();
		} else {
			return 0;
		}

	}

}
