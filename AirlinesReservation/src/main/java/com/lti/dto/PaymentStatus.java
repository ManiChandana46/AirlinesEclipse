package com.lti.dto;

import org.springframework.stereotype.Component;

@Component
public class PaymentStatus extends Status {

	private int transactionId;
	private int bookingId;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

}
