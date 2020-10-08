package com.lti.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.FlightRoute;
import com.lti.entity.FlightSchedule;

@Repository
public class ViewFlightRepositoryImpl implements ViewFlightRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> listOfFlightNumber() {
		return new ArrayList<Integer>(entityManager
				.createQuery("select f.flightNumber from FlightDetail f")
				.getResultList());
	}

	@Override
	public int flightIdByFlightNumber(int flightNumber) {
		return (Integer) entityManager
				.createQuery("select f.flightId from FlightDetail f where f.flightNumber= :flightNumber")
				.setParameter("flightNumber", flightNumber)
				.setMaxResults(1)
				.getSingleResult();
	}

	@Override
	public LocalDate initialDateByFlightNumber(int flightNumber) {
		return (LocalDate) entityManager
				.createQuery("select f.initialDate from FlightDetail f where f.flightNumber= :flightNumber")
				.setParameter("flightNumber", flightNumber)
				.setMaxResults(1)
				.getSingleResult();
	}

	@Override
	public LocalDate finalDateByFlightNumber(int flightNumber) {
		return (LocalDate) entityManager
				.createQuery("select f.finalDate from FlightDetail f where f.flightNumber= :flightNumber")
				.setParameter("flightNumber", flightNumber)
				.setMaxResults(1)
				.getSingleResult();

	}

	@Override
	public int routeIdByFlightId(int flightId) {
		return (Integer) entityManager
				.createQuery("select s.flightRoute.routeId from FlightSchedule s where s.flightDetail.flightId= :flightId")
				.setParameter("flightId", flightId)
				.setMaxResults(1)
				.getSingleResult();
	}

	@Override
	public FlightRoute getCityByRouteId(int routeId) {
		return entityManager
				.createQuery("select r from FlightRoute r where r.routeId= :routeId", FlightRoute.class)
				.setParameter("routeId", routeId)
				.setMaxResults(1)
				.getSingleResult();
	}

	@Override
	public FlightSchedule getScheduleByFlightId(int flightId) {
		return entityManager
				.createQuery("select s from FlightSchedule s where s.flightDetail.flightId= :flightId",FlightSchedule.class)
				.setParameter("flightId", flightId)
				.setMaxResults(1)
				.getSingleResult();

	}
}
