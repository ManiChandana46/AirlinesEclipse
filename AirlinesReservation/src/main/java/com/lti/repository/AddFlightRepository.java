package com.lti.repository;

public interface AddFlightRepository {

	int findRouteId(String fromCity, String toCity);

	int findFlightId(int flightNumber);

}