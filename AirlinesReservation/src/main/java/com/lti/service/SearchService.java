package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.ReturnResult;
import com.lti.dto.SearchDetails;
import com.lti.dto.SearchResult;
import com.lti.dto.TotalResult;
import com.lti.exception.AirlinesServiceException;
import com.lti.repository.SearchRepository;

@Service
public class SearchService {
	
	@Autowired
	private SearchRepository searchRepository;
	
	public TotalResult searchFlight(SearchDetails searchDetails)
	{
		if(searchDetails.getReturnTravelDate()==null)
		{
			List<SearchResult> list=searchRepository.searchFlights(searchDetails);
			if(list.isEmpty())
			{
				throw new AirlinesServiceException("Flights are not available at this moment");
			}
			TotalResult totalResult=new TotalResult();
			totalResult.setSearchResults(list);
			totalResult.setStatusMessage("Successful");
			return totalResult;
		}
		else if(searchDetails.getReturnTravelDate()!=null)
		{
			List<SearchResult> list=searchRepository.searchFlights(searchDetails);
			List<ReturnResult> list1=searchRepository.searchReturnFlights(searchDetails);
			if(!list.isEmpty() && list1.isEmpty())
			{
				throw new AirlinesServiceException("Return Flights are not available at this moment try another date");
			}
			if(list.isEmpty() || list1.isEmpty())
			{
				throw new AirlinesServiceException("Departure and Return Flights are not available at this moment");
			}
			TotalResult totalResult=new TotalResult();
			totalResult.setSearchResults(list);
			totalResult.setReturnResults(list1);
			totalResult.setStatusMessage("Successful");
			return totalResult;	
		}
		return null;
	}

}
