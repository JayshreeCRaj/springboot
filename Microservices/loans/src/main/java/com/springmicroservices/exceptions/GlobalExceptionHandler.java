package com.springmicroservices.exceptions;

import java.time.LocalDateTime;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(LoanNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(LoanNotFoundException ex){
		log.info("Handling Loan Related Exception");
	
		ErrorResponse response =ErrorResponse.builder().
		errorCode(HttpStatus.BAD_REQUEST.value()).
		status(HttpStatus.BAD_REQUEST).
		message("Client Side Error").
		exceptionMessage(Collections.singletonList(ex.getMessage())).
		timestamp(LocalDateTime.now()).
		build();
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {
		
		ErrorResponse reponse = ErrorResponse.builder().
		errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).
		status(HttpStatus.INTERNAL_SERVER_ERROR).
		message("Something Went Wrong").
		exceptionMessage(Collections.singletonList(ex.getMessage())).
		timestamp(LocalDateTime.now()).
		build();
		return new ResponseEntity<>(reponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
