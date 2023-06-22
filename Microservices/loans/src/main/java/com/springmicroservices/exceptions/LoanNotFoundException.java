package com.springmicroservices.exceptions;

public class LoanNotFoundException extends RuntimeException {

	public LoanNotFoundException(String message) {
		super(message);
	}

}
