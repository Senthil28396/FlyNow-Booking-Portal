package com.springsecurity.exception;

@SuppressWarnings("serial")
public class FlightNotFoundException extends RuntimeException {
	public FlightNotFoundException(String exception) {
		super(exception);
	}

}
