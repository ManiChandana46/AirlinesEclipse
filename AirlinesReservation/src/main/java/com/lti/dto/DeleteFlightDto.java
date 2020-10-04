package com.lti.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class DeleteFlightDto {

	private int flightNumber;
	private LocalDate travelDate;
	public int getFlightNumber() {
		return flightNumber;
	}
	
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	
}
