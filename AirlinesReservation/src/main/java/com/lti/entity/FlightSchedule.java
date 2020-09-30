package com.lti.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Flight_Schedule_Details")
public class FlightSchedule {
	
	@Id
	@GeneratedValue
	@Column(name = "Schedule_id")
	private int scheduleId;
	
	@Column(name = "Flight_departure_time")
	private String departureTime;
	
	@Column(name = "Flight_arrival_time")
	private String arrivalTime;
	
	@Column(name  = "Flight_seat_available")
	private int seatAvailable;
	
	@Column( name = "date_of_travel")
	private LocalDate dateOfTravel;
	
	@Column(name = "Flight_price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "Flight_route_id")
	private FlightRoute flightRoute;
	
	@ManyToOne
	@JoinColumn(name = "Flight_id")
	private FlightDetail flightDetail;
	
	@OneToMany(mappedBy = "flightSchedule" , cascade = CascadeType.ALL)
	private List<ReturnDetail> returnDetails;
	
	@OneToMany(mappedBy = "flightSchedule" , cascade = CascadeType.ALL)
	private List<FlightBookingDetail> flightBookingDetails;

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}


	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getSeatAvailable() {
		return seatAvailable;
	}

	public void setSeatAvailable(int seatAvailable) {
		this.seatAvailable = seatAvailable;
	}

	
	public LocalDate getDateOfTravel() {
		return dateOfTravel;
	}

	public void setDateOfTravel(LocalDate dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}

	public FlightDetail getFlightDetail() {
		return flightDetail;
	}

	public void setFlightDetail(FlightDetail flightDetail) {
		this.flightDetail = flightDetail;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public FlightRoute getFlightRoute() {
		return flightRoute;
	}

	public void setFlightRoute(FlightRoute flightRoute) {
		this.flightRoute = flightRoute;
	}

	public FlightDetail getFlightDetails() {
		return flightDetail;
	}

	public void setFlightDetails(FlightDetail flightDetail) {
		this.flightDetail = flightDetail;
	}

	public List<ReturnDetail> getReturnDetails() {
		return returnDetails;
	}

	public void setReturnDetails(List<ReturnDetail> returnDetails) {
		this.returnDetails = returnDetails;
	}

	public List<FlightBookingDetail> getFlightBookingDetails() {
		return flightBookingDetails;
	}

	public void setFlightBookingDetails(List<FlightBookingDetail> flightBookingDetails) {
		this.flightBookingDetails = flightBookingDetails;
	}

	
	
	
}
