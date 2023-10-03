package com.springsecurity.exception;

@SuppressWarnings("serial")
public class ReservationNotFoundException extends RuntimeException {
	public ReservationNotFoundException(String exception) {
		super(exception);
	}

}
