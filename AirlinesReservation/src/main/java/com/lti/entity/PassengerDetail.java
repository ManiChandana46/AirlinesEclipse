package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Passenger_data")
public class PassengerDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
	@SequenceGenerator(name = "myseq", sequenceName = "passenger_seq", allocationSize = 1, initialValue = 1000)

	@Column(name = "passenger_id")
	private int passengerId;

	@Column(name = "passenger_name")
	private String name;
	@Column(name = "passenger_age")
	private int age;
	@Column(name = "passenger_gender")
	private Gender gender;

	@ManyToOne
	@JoinColumn(name = "flight_book_id")
	private FlightBookingDetail flightBookingDetail;

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public enum Gender {
		Male, Female
	}

	public FlightBookingDetail getFlightBookingDetails() {
		return flightBookingDetail;
	}

	public void setFlightBookingDetails(FlightBookingDetail flightBookingDetail) {
		this.flightBookingDetail = flightBookingDetail;
	}

}
