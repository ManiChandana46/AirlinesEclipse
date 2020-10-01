package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.dto.ReturnResult;
import com.lti.dto.SearchDetails;
import com.lti.dto.SearchResult;

@Repository
public class SearchRepository extends GenericRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<SearchResult> searchFlights(SearchDetails searchDetails)
	{
		return  entityManager.createQuery("select s.arrivalTime,s.departureTime,s.dateOfTravel,s.price,s.scheduleId,r.cityFrom,r.cityTo,r.duration from FlightSchedule s join s.flightRoute r where r.cityFrom= :from and r.cityTo= :to and s.dateOfTravel= :date")
											 .setParameter("from", searchDetails.cityFrom)
											 .setParameter("to", searchDetails.cityTo)
											 .setParameter("date", searchDetails.travelDate)
											 .getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<ReturnResult> searchReturnFlights(SearchDetails searchDetails)
	{
		return  entityManager.createQuery("select s.arrivalTime,s.departureTime,s.dateOfTravel,s.price,s.scheduleId,r.cityFrom,r.cityTo,r.duration from FlightSchedule s join s.flightRoute r where r.cityFrom= :from and r.cityTo= :to and s.dateOfTravel= :date")
											 .setParameter("from", searchDetails.cityTo)
											 .setParameter("to", searchDetails.cityFrom)
											 .setParameter("date", searchDetails.returnTravelDate)
											 .getResultList();
	}

}
