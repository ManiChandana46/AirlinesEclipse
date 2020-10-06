package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ViewFlightDto;
import com.lti.service.ViewFlightService;

@RestController
@CrossOrigin
public class ViewFlightController {

	@Autowired
	private ViewFlightService viewFlightService;
	
	@PutMapping(path = "/viewFlight")
	public List<ViewFlightDto> viewFlight() {
		return viewFlightService.getView();
	}
}
