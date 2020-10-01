package com.lti.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingDetail {
	private int bookingId ;
	private LocalDateTime dateOfBooking;
	private LocalDate dateOfJourney;
	private int numberOfSeats;
	private String flightSeatsSelected;
	private String from;
	private String to;
	private String startTime;
	private String endTime;
	private String classType;
	private double price;
	private String duration;
	private ReturnDetail returnDetail;
	
	
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public String getFlightSeatsSelected() {
		return flightSeatsSelected;
	}
	public void setFlightSeatsSelected(String flightSeatsSelected) {
		this.flightSeatsSelected = flightSeatsSelected;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public LocalDateTime getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(LocalDateTime dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public ReturnDetail getReturnDetail() {
		return returnDetail;
	}
	public void setReturnDetail(ReturnDetail returnDetail) {
		this.returnDetail = returnDetail;
	}
	
	

}
