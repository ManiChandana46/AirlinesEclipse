package com.lti.service;

import java.util.List;

import com.lti.dto.SearchDetails;
import com.lti.dto.TotalResult;

public interface SearchService {

	TotalResult searchFlight(SearchDetails searchDetails);

	List<String> blockedSeats(int scheduleId);

}