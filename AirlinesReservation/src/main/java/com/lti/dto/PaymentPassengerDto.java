package com.lti.dto;

public class PaymentPassengerDto {

	private String name;
	private int age;
	private int gender;
	private int flightBookId;

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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getFlightBookId() {
		return flightBookId;
	}

	public void setFlightBookId(int flightBookId) {
		this.flightBookId = flightBookId;
	}

}
