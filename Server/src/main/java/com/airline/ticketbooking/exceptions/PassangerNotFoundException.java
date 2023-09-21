package com.airline.ticketbooking.exceptions;

@SuppressWarnings("serial")
public class PassangerNotFoundException extends RuntimeException {

	public PassangerNotFoundException(String exception) {
		super(exception);
	}

}
