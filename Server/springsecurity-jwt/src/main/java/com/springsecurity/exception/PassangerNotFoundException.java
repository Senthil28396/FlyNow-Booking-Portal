package com.springsecurity.exception;

@SuppressWarnings("serial")
public class PassangerNotFoundException extends Exception{

	public PassangerNotFoundException(String message) {
		super(message);
	}

}
