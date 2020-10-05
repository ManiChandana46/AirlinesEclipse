package com.lti.repository;

import java.time.LocalDate;
import java.util.List;

public interface DeleteFlightRepository {

	int flightIdByFlightNumber(int flightNumber);

	int scheduleIdByFlightIdAndTravelDate(int flightId, LocalDate travelDate);

	List<Integer> listOfBookIdByScheduleId(int scheduleId);
	
	List<Integer> listOfReturnIdByScheduleId(int scheduleId);
	
	void refereneceDeletionOfReturnIdFromBookTable(int returnId);

	int customerIdByBookId(int bookId);
	
	int bookIdByReturnId(int returnId);

	int isReturnPresent(int bookId);
	
	void deletionFromReturnDetail(int returnId);

	void deleteReturnDetailByReturnId(int returnId);

	void deletePassengerByBookId(int bookId);

	void deletePaymentByBookId(int bookId);

	void deleteBookingByBookId(int bookId);

	void deleteFlightScheduleByFlightIdAndTravelDate(int flightId, LocalDate travelDate);

	void deleteFlightDetailByFlightNumber(int flightNumber);

}