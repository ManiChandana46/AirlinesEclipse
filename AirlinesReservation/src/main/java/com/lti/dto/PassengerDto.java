package com.lti.dto;

import com.lti.entity.PassengerDetail.Gender;

public class PassengerDto {
	
	private String name;
	private int age;
	private Gender gender;
	private String seatAlloted;
	
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
	public String getSeatAlloted() {
		return seatAlloted;
	}
	public void setSeatAlloted(String seatAlloted) {
		this.seatAlloted = seatAlloted;
	}
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
}
