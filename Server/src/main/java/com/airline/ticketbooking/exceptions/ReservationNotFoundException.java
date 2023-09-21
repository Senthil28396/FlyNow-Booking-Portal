package com.airline.ticketbooking.exceptions;

@SuppressWarnings("serial")
public class ReservationNotFoundException extends RuntimeException {
	public ReservationNotFoundException(String exception) {
		super(exception);
	}

}
