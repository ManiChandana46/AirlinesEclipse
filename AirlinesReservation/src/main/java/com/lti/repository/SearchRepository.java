package com.lti.repository;

import java.util.List;

import com.lti.dto.ReturnResult;
import com.lti.dto.SearchDetails;
import com.lti.dto.SearchResult;

public interface SearchRepository {

	List<SearchResult> searchFlights(SearchDetails searchDetails);

	List<ReturnResult> searchReturnFlights(SearchDetails searchDetails);

	List<String> blockedSeats(int scheduleId);

	boolean isSchedulePresent(int scheduleId);

}