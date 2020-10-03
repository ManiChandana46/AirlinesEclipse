package com.lti.dto;

import java.time.LocalDate;

public class PaymentReturnDto {

	private int noOfSeats;
	private String seatSelected;
	private String returnClass;
	private LocalDate returnTravelDate;
	private int scheduleId;

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

	public String getReturnClass() {
		return returnClass;
	}

	public void setReturnClass(String returnClass) {
		this.returnClass = returnClass;
	}

	public LocalDate getReturnTravelDate() {
		return returnTravelDate;
	}

	public void setReturnTravelDate(LocalDate returnTravelDate) {
		this.returnTravelDate = returnTravelDate;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

}
