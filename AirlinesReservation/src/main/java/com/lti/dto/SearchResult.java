package com.lti.dto;

import java.time.LocalDate;


public class SearchResult {
	
	//s.arrivalTime,s.departureTime,s.dateOfTravel,s.price,s.scheduleId,r.cityFrom,r.cityTo,r.duration
	
	private int scheduleId;
	private String arrivalTime;
	private String departureTime;
	private LocalDate dateOfTravel;
	private double price;
	private String cityFrom;
	private String cityTo;
	private int duration;
	
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDate getDateOfTravel() {
		return dateOfTravel;
	}
	public void setDateOfTravel(LocalDate dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	
	
	
	
	

}
