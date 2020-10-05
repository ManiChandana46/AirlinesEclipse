package com.lti.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.DeleteFlightDto;
import com.lti.dto.DeleteFlightStatusDto;
import com.lti.exception.AirlinesServiceException;
import com.lti.service.DeleteFlightService;

@RestController
@CrossOrigin
public class DeleteFlightController {

	@Autowired
	private DeleteFlightService deleteFlightService;

	@Autowired
	private DeleteFlightStatusDto deleteFlightStatusDto;

	@PostMapping( path = "/flightDelete")
	public DeleteFlightStatusDto deleteFlight( @RequestBody DeleteFlightDto deleteFlightDto) {
		//try {
			int flightNumber =  deleteFlightDto.getFlightNumber();
			LocalDate travelDate = deleteFlightDto.getTravelDate();
			return deleteFlightService.deleteFlight(flightNumber, travelDate);
		//}
//		catch(AirlinesServiceException e) {
//			deleteFlightStatusDto.setStatus(false);
//			deleteFlightStatusDto.setMessage("Flight Deletion Failed!");
//			return deleteFlightStatusDto;
//		}
	}
}
