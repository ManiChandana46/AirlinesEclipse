package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Flight_Book_Details")
public class FlightBookingDetail {
	
	@Id
	@GeneratedValue
	@Column(name="Flight_book_Id")
	private int bookId;
	
	@Column(name="Flight_no_of_seats")
	private int noOfSeats;
	
	@Column(name="Flight_seats_selected")
	private String seatSelected;
	
	@Column(name="Flight_class")
	private String flightClass;
	
	@Column(name="Travel_date")
	private LocalDate travelDate;
	
	@OneToOne
	@JoinColumn(name="Return_Id")
	private ReturnDetail returnDetail;
	
	@OneToMany(mappedBy = "flightBookingDetail")
	private List<PassengerDetail> passengerDetails;
	
	@ManyToOne
	@JoinColumn(name="Customer_Id")
	private CustomerDetail customerDetail;
	
	@ManyToOne
	@JoinColumn(name="Schedule_Id")
	private FlightSchedule flightSchedule;
	
	@OneToOne(mappedBy = "flightBookingDetail")
	private PaymentDetail paymentDetail;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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


	public ReturnDetail getReturnDetail() {
		return returnDetail;
	}

	public void setReturnDetail(ReturnDetail returnDetail) {
		this.returnDetail = returnDetail;
	}

	public List<PassengerDetail> getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(List<PassengerDetail> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}

	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}

	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}
	
	

}
