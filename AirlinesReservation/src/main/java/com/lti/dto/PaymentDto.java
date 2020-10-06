package com.lti.dto;

import java.time.LocalDate;
import java.util.List;


public class PaymentDto {

	private double transactionAmount;
	private String paymentType;
	private String cardNumber;
	private int customerId;
	private int scheduleId;

	private int noOfSeats;
	private String seatSelected;
	private String flightClass;
	private LocalDate travelDate;

	private boolean returnStatus;
	private int returnNoOfSeats;
	private String returnSeatSelected;
	private String returnClass;
	private LocalDate returnTravelDate;
	private int returnScheduleId;

	private List<PassengerDto> passengerDetails;

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
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

	public boolean isReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(boolean returnStatus) {
		this.returnStatus = returnStatus;
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

	public int getReturnScheduleId() {
		return returnScheduleId;
	}

	public void setReturnScheduleId(int returnScheduleId) {
		this.returnScheduleId = returnScheduleId;
	}

	public List<PassengerDto> getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(List<PassengerDto> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}

	

}
