package com.airline.ticketbooking.exceptions;

@SuppressWarnings("serial")
public class FlightNotFoundException extends RuntimeException {
	public FlightNotFoundException(String exception) {
		super(exception);
	}

}
