package com.lti.entity;

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
@Table(name = "Flight_Scheduling")
public class FlightSchedule {
	
	@Id
	@GeneratedValue
	@Column(name = "Schedule_id")
	private int scheduleId;
	
	
	@Column(name = "Flight_departure_time")
	private LocalTime departureTime;
	
	@Column(name = "Flight_arrival_time")
	private LocalTime arrivalTime;
	
	@Column(name  = "Flight_seat_available")
	private int seatAvailable;
	
	@Column( name = "Week_day")
	private String weekDay;
	
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

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getSeatAvailable() {
		return seatAvailable;
	}

	public void setSeatAvailable(int seatAvailable) {
		this.seatAvailable = seatAvailable;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
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
