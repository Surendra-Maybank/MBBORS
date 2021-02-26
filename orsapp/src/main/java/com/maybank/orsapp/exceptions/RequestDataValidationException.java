package com.maybank.orsapp.exceptions;

public class RequestDataValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2442811634674921058L;

	/**
	 * @param message
	 */
	public RequestDataValidationException(String message) {
		super(message);
	}

}
