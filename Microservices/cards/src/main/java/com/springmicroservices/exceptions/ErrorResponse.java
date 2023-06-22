package com.springmicroservices.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorResponse {
	
	private HttpStatus status;
	private Integer errorCode;
	private String message;
	private List<String> exceptionMessage;
	private LocalDateTime timestamp;	

}

