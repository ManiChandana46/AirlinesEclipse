package com.lti.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Return_Details")
public class ReturnDetail {
	
	@Id
	@GeneratedValue
	@Column(name="Return_Id")
	private int returnId;
	
	@Column(name="Flight_no_of_seats")
	private int noOfSeats;
	
	@Column(name="Flight_seats_selected")
	private String seatSelected;
	
	@Column(name="Return_class")
	private String returnClass;
	
	@Column(name="Return_Travel_date")
	private LocalDate returnTravelDate;
	
	@Column(name="Return_arrival_date")
	private LocalDate returnArrivalDate;
	
	@ManyToOne
	@JoinColumn(name="Schedule_Id")
	private FlightSchedule flightSchedule;
	
	@OneToOne(mappedBy = "returnDetail" )
	private FlightBookingDetail flightBookingdetail;

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
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

	public LocalDate getReturnArrivalDate() {
		return returnArrivalDate;
	}

	public void setReturnArrivalDate(LocalDate returnArrivalDate) {
		this.returnArrivalDate = returnArrivalDate;
	}

	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}

	public FlightBookingDetail getFlightBookingdetail() {
		return flightBookingdetail;
	}

	public void setFlightBookingdetail(FlightBookingDetail flightBookingdetail) {
		this.flightBookingdetail = flightBookingdetail;
	}

	
	
	

}
