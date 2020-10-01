package com.lti.dto;

import java.time.LocalDate;

public class SearchDetails {
	
	public String cityFrom;
	public String cityTo;
	public LocalDate travelDate;
	public LocalDate returnTravelDate;
	public int noOfPassengers;
	
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
	
	
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	
	public LocalDate getReturnTravelDate() {
		return returnTravelDate;
	}
	public void setReturnTravelDate(LocalDate returnTravelDate) {
		this.returnTravelDate = returnTravelDate;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	
	

}
