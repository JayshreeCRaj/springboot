package com.springbootdemo.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(CategoryNotFoundException ex) {
		log.info("Handle Exception");
		/*
		 * ErrorResponse errorResponse = new ErrorResponse();
		 * errorResponse.setStatus(HttpStatus.BAD_REQUEST);
		 * errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
		 * errorResponse.setMessage("Client Side Error");
		 * errorResponse.setExceptionMessage(Collections.singletonList(ex.getMessage()))
		 * ; errorResponse.setTimestamp(LocalDateTime.now());
		 */
		
		ErrorResponse reponse = ErrorResponse.builder().
				errorCode(HttpStatus.BAD_REQUEST.value()).
				status(HttpStatus.BAD_REQUEST).
				message("Client Side Error").
				exceptionMessage(Collections.singletonList(ex.getMessage())).
				timestamp(LocalDateTime.now()).
				build();
		return new ResponseEntity<>(reponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {
		
		/*
		 * ErrorResponse errorResponse = new ErrorResponse();
		 * errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		 * errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		 * errorResponse.setMessage("Something Went Wrong");
		 * errorResponse.setExceptionMessage(Collections.singletonList(ex.getMessage()))
		 * ; errorResponse.setTimestamp(LocalDateTime.now());
		 * 
		 * return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		 */
		
		ErrorResponse reponse = ErrorResponse.builder().
				errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).
				status(HttpStatus.INTERNAL_SERVER_ERROR).
				message("Something Went Wrong").
				exceptionMessage(Collections.singletonList(ex.getMessage())).
				timestamp(LocalDateTime.now()).
				build();
		return new ResponseEntity<>(reponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<String> details = new ArrayList<>();
		var errorList= ex.getBindingResult().getAllErrors();
		for(ObjectError err : errorList) {
			details.add(err.getDefaultMessage());
		}
		/*
		 * ErrorResponse errorResponse = new ErrorResponse();
		 * errorResponse.setStatus(HttpStatus.BAD_REQUEST);
		 * errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
		 * errorResponse.setMessage("Validation Failed");
		 * errorResponse.setExceptionMessage(details);
		 * errorResponse.setTimestamp(LocalDateTime.now()); return new
		 * ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		 */
		
		ErrorResponse reponse = ErrorResponse.builder().
				errorCode(HttpStatus.BAD_REQUEST.value()).
				status(HttpStatus.BAD_REQUEST).
				message("Validation Failed").
				exceptionMessage(Collections.singletonList(ex.getMessage())).
				timestamp(LocalDateTime.now()).
				build();
		return new ResponseEntity<>(reponse, HttpStatus.BAD_REQUEST);
	}
}
