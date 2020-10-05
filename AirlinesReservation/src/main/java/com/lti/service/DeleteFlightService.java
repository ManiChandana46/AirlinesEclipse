package com.lti.service;

import java.time.LocalDate;

import com.lti.dto.DeleteFlightStatusDto;

public interface DeleteFlightService {

	DeleteFlightStatusDto deleteFlight(int flightNumber, LocalDate travelDate);

}