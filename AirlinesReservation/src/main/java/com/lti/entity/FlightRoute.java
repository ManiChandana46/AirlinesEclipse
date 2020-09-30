package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Flight_Routes")
public class FlightRoute {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
	@SequenceGenerator(name = "myseq", sequenceName = "flightRoute_sequence", allocationSize = 1, initialValue = 1)
	@Column(name = "Flight_route_id")
	private int routeId;
	
	@Column(name = "Flight_city_from")
	private String cityFrom;
	
	@Column(name = "Flight_city_to")
	private String cityTo;
	
	@Column(name = "Flight_duration")
	private int duration;
	
	@OneToMany(mappedBy = "flightRoute" , cascade = CascadeType.ALL)
	private List<FlightSchedule> flightSchedules;

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getCityFrom() {
		return cityFrom;
	}

	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}

	public String getCityTo() {
		return cityTo;
	}

	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<FlightSchedule> getFlightSchedules() {
		return flightSchedules;
	}

	public void setFlightSchedules(List<FlightSchedule> flightSchedules) {
		this.flightSchedules = flightSchedules;
	}

	
}
