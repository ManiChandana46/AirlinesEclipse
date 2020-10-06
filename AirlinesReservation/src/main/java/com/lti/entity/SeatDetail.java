package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="seat_status")
public class SeatDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
	@SequenceGenerator(name = "myseq", sequenceName = "seat_seq", allocationSize = 1, initialValue = 3000)
	private int seatId;
	
	@ManyToOne
	@JoinColumn(name="Schedule_Id")
	private FlightSchedule flightSchedule;
	
	private String seatName;
	
	private boolean status;
	
	@OneToOne(mappedBy = "seatDetail")
	private PassengerDetail passengerDetail;
	
	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public PassengerDetail getPassengerDetail() {
		return passengerDetail;
	}

	public void setPassengerDetail(PassengerDetail passengerDetail) {
		this.passengerDetail = passengerDetail;
	}
	
	
	

}
