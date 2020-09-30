package com.lti.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Payment_Details")
public class PaymentDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
	@SequenceGenerator(name = "myseq", sequenceName = "payment_seq", allocationSize = 1, initialValue = 700)

	@Column(name="Transaction_Id")
	private int transactionId;
	
	@Column(name="Transaction_amount")
	private double transactionAmount;
	
	@Column(name="Transaction_time")
	private LocalDateTime transactionTime;
	
	@Column(name="Payment_type")
	private String paymentType;
	
	@Column(name="Payment_card_number")
	private long cardNumber;
	
	@OneToOne
	@JoinColumn(name="Flight_book_Id")
	private FlightBookingDetail flightBookingDetail;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public FlightBookingDetail getFlightBookingDetail() {
		return flightBookingDetail;
	}

	public void setFlightBookingDetail(FlightBookingDetail flightBookingDetail) {
		this.flightBookingDetail = flightBookingDetail;
	}
	
	

}
