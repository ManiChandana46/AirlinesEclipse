package com.lti.service;

import com.lti.dto.AddFlightDto;
import com.lti.dto.AddFlightStatus;
import com.lti.entity.FlightDetail;
import com.lti.entity.FlightRoute;

public interface AddFlightService {

	FlightDetail addFlightDetails(AddFlightDto addFlightDto);

	FlightRoute getRouteId(AddFlightDto addFlightDto);

	AddFlightStatus addToSchedule(FlightDetail flightDetail, FlightRoute flightRoute, AddFlightDto addFlightDto);

}