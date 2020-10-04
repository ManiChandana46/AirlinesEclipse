package com.lti.repository;

import java.time.LocalDate;
import java.util.List;

public interface DeleteFlighRepository {

	int flightIdByFlightNumber(int flightNumber);

	int scheduleIdByFlightIdAndTravelDate(int flightId, LocalDate travelDate);

	List<Integer> listOfBookIdByScheduleId(int scheduleId);

	int customerIdByBookId(int bookId);

	int isReturnPresent(int bookId);

	void deleteReturnDetailByReturnId(int returnId);

	void deletePassengerByBookId(int bookId);

	void deletePaymentByBookId(int bookId);

	void deleteBookingByScheduleId(int scheduleId);

	void deleteFlightScheduleByFlightIdAndTravelDate(int flightId, LocalDate travelDate);

	void deleteFlightDetailByFlightNumber(int flightNumber);

}