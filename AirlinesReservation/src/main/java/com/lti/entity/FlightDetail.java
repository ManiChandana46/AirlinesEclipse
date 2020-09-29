package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Flight_Details")
public class FlightDetail {
	
	@Id
	@GeneratedValue
	@Column(name = "Flight_id")
	private int flightId;
	
	@Column(name = "Flight_number")
	private int flightNumber;
	
	@Column(name = "Flight_cabin")
	private int cabin;
	
	@OneToMany(mappedBy = "flightDetail" , cascade = CascadeType.ALL)
	private List<FlightSchedule> flightSchedules;

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getCabin() {
		return cabin;
	}

	public void setCabin(int cabin) {
		this.cabin = cabin;
	}

	public List<FlightSchedule> getFlightSchedules() {
		return flightSchedules;
	}

	public void setFlightSchedules(List<FlightSchedule> flightSchedules) {
		this.flightSchedules = flightSchedules;
	}

	
}
