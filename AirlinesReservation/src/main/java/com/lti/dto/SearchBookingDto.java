package com.lti.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class SearchBookingDto {

	private int bookId;
	private int noOfSeats;
	private String seatSelected;
	private String flightClass;
	private LocalDate travelDate;
	private int returnId;
	private int returnNoOfSeats;
	private String returnSeatSelected;
	private String returnFlightClass;
	//private LocalDateTime dateOfBooking;
	private String to;
	private String from;
	private String startTime;
	private String endTime;
	private double price;
	private LocalDate returnTravelDate;
	//private LocalDateTime returndateOfBooking;
	private String returnTo;
	private String returnFrom;
	private String returnStartTime;
	private String returnEndTime;
	//private double returnPrice;
	private int duration;
	private int returnDuration;
	
	
	

	public int getReturnDuration() {
		return returnDuration;
	}

	public void setReturnDuration(int returnDuration) {
		this.returnDuration = returnDuration;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getReturnTo() {
		return returnTo;
	}

	public void setReturnTo(String returnTo) {
		this.returnTo = returnTo;
	}

	public String getReturnFrom() {
		return returnFrom;
	}

	public void setReturnFrom(String returnFrom) {
		this.returnFrom = returnFrom;
	}

	public String getReturnStartTime() {
		return returnStartTime;
	}

	public void setReturnStartTime(String returnStartTime) {
		this.returnStartTime = returnStartTime;
	}

	public String getReturnEndTime() {
		return returnEndTime;
	}

	public void setReturnEndTime(String returnEndTime) {
		this.returnEndTime = returnEndTime;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getSeatSelected() {
		return seatSelected;
	}

	public void setSeatSelected(String seatSelected) {
		this.seatSelected = seatSelected;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public int getReturnNoOfSeats() {
		return returnNoOfSeats;
	}

	public void setReturnNoOfSeats(int returnNoOfSeats) {
		this.returnNoOfSeats = returnNoOfSeats;
	}

	public String getReturnSeatSelected() {
		return returnSeatSelected;
	}

	public void setReturnSeatSelected(String returnSeatSelected) {
		this.returnSeatSelected = returnSeatSelected;
	}

	public String getReturnFlightClass() {
		return returnFlightClass;
	}

	public void setReturnFlightClass(String returnFlightClass) {
		this.returnFlightClass = returnFlightClass;
	}

	public LocalDate getReturnTravelDate() {
		return returnTravelDate;
	}

	public void setReturnTravelDate(LocalDate returnTravelDate) {
		this.returnTravelDate = returnTravelDate;
	}

	

}
