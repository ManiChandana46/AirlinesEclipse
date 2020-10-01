package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AddFlightDto;
import com.lti.dto.AddFlightStatus;
import com.lti.entity.FlightDetail;
import com.lti.entity.FlightRoute;
import com.lti.service.AddFlightService;

@RestController
public class AddFlightController {

	@Autowired
	private AddFlightService addFlightService;
	
	@PostMapping(path = "/addFlight")
	public AddFlightStatus addFlight(@RequestBody AddFlightDto addFlightDto) {
		FlightDetail flightDetail = addFlightService.addFlightDetails(addFlightDto);
		FlightRoute flightRoute = addFlightService.getRouteId(addFlightDto);
		return addFlightService.addToSchedule(flightDetail, flightRoute, addFlightDto);
	}
}
