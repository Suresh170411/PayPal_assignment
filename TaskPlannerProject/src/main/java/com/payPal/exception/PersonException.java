package com.payPal.exception;

public class PersonException extends RuntimeException {

	public PersonException () {
		
	}
	
	public PersonException (String message) {
		super(message);
	}
}
