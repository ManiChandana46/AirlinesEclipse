package com.lti.repository;

import java.time.LocalDate;
import java.util.List;
import com.lti.entity.FlightRoute;
import com.lti.entity.FlightSchedule;

public interface ViewFlightRepository {

	List<Integer> listOfFlightNumber();

	int flightIdByFlightNumber(int flightNumber);

	LocalDate initialDateByFlightNumber(int flightNumber);

	LocalDate finalDateByFlightNumber(int flightNumber);

	int routeIdByFlightId(int flightId);

	FlightRoute getCityByRouteId(int routeId);

	FlightSchedule getScheduleByFlightId(int flightId);

}