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

	private LocalDate returnTravelDate;

}
