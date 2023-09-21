package com.airline.ticketbooking.exceptions;

@SuppressWarnings("serial")
public class CategoryNotFoundException extends RuntimeException {

	public CategoryNotFoundException(String exception) {
		super(exception);
	}

}
