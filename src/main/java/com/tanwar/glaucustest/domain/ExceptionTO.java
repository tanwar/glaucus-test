package com.tanwar.glaucustest.domain;

/**
 * Exception response class.
 * @author Tanwar
 *
 */
public class ExceptionTO {

	private ErrorCodes code;
	private String message;

	public ErrorCodes getCode() {
		return code;
	}

	public void setCode(ErrorCodes code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
