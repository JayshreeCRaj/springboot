package com.springmicroservices.exceptions;

public class AccountNotExistException extends RuntimeException {

	public AccountNotExistException(String message) {
		super(message);
	}
	
	

}
