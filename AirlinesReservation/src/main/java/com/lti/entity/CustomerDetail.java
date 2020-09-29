package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Table")
public class CustomerDetail {

	@Id
	@GeneratedValue
	@Column(name = "Customer_id")
	private int customerId;

	@Column(name = "Customer_firstname")
	private String customerFirstName;
	
	@Column(name = "Customer_lastname")
	private String customerLastName;
	
	@Column(name = "Customer_email")
	private String customerEmail;
	
	@Column(name = "Customer_password")
	private String customerPassword;
	
	@Column(name = "Customer_dateOfBirth")
	private LocalDate customerDateOfBirth;
	
	@Column(name = "Customer_phoneNo")
	private int customerPhoneNo;

	@OneToMany(mappedBy = "customerDetail", cascade = CascadeType.ALL)
	private List<FlightBookingDetail> flightBookingDetails;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public LocalDate getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}

	public void setCustomerDateOfBirth(LocalDate customerDateOfBirth) {
		this.customerDateOfBirth = customerDateOfBirth;
	}

	public int getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(int customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public List<FlightBookingDetail> getFlightBookingDetails() {
		return flightBookingDetails;
	}

	public void setFlightBookingDetails(List<FlightBookingDetail> flightBookingDetails) {
		this.flightBookingDetails = flightBookingDetails;
	}

}
