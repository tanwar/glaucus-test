package com.tanwar.glaucustest.exception;

/**
 * Exception class for person not found.
 * @author Tanwar
 *
 */
public class PersonNotFoundException extends RuntimeException {
	
	private String message;
	
	public PersonNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
