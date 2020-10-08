package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class AddFlightRepositoryImp implements AddFlightRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int findRouteId(String fromCity, String toCity) {
		return (Integer) entityManager
				.createQuery("select r.routeId from FlightRoute r where r.cityFrom= :from and r.cityTo= :to")
				.setParameter("from", fromCity).setParameter("to", toCity).getSingleResult();
	}

	@Override
	public int findFlightId(int flightNumber) {
		return (Integer) entityManager
				.createQuery("select f.flightId from FlightDetail f where f.flightNumber= :flightNumber")
				.setParameter("flightNumber", flightNumber).getSingleResult();
	}

}
