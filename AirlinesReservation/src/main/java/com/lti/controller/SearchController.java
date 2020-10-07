package com.lti.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.SearchDetails;
import com.lti.dto.TotalResult;
import com.lti.exception.AirlinesServiceException;
import com.lti.service.SearchService;

@RestController
@CrossOrigin
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@PostMapping("/search")
	public TotalResult searchFlight(@RequestBody SearchDetails searchDetails)
	{
		try{
			TotalResult totalResult=searchService.searchFlight(searchDetails);
			return totalResult;	
		}
		catch (AirlinesServiceException airlines) {
			TotalResult totalResult=new TotalResult();
			totalResult.setStatusMessage(airlines.getMessage());
			return totalResult;
		}
	}
	
	@GetMapping("/blockedSeats")
	public List<String> blockedSeats(int scheduleId)
	{
		try{
			return searchService.blockedSeats(scheduleId);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
