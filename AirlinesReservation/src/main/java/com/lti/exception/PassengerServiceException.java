package com.lti.exception;

@SuppressWarnings("serial")
public class PassengerServiceException extends RuntimeException {

	public PassengerServiceException() {
		super();

	}

	public PassengerServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public PassengerServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public PassengerServiceException(String message) {
		super(message);

	}

	public PassengerServiceException(Throwable cause) {
		super(cause);

	}

}
