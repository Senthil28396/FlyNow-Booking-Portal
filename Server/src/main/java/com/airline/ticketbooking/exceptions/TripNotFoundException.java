package com.airline.ticketbooking.exceptions;

@SuppressWarnings("serial")
public class TripNotFoundException extends RuntimeException {
	public TripNotFoundException(String exception) {
		super(exception);
	}

}
