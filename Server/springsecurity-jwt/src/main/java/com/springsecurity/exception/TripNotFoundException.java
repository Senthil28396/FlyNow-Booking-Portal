package com.springsecurity.exception;

@SuppressWarnings("serial")
public class TripNotFoundException extends RuntimeException {
	public TripNotFoundException(String exception) {
		super(exception);
	}

}
