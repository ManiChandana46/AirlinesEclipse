package com.lti.exception;

@SuppressWarnings("serial")
public class AirlinesServiceException extends RuntimeException {

	public AirlinesServiceException() {
		super();
	}

	public AirlinesServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AirlinesServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AirlinesServiceException(String message) {
		super(message);
	}

	public AirlinesServiceException(Throwable cause) {
		super(cause);
	}

}
