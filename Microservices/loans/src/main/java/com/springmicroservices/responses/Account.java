package com.springmicroservices.responses;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter

public class Account {
	
	private Integer accountNumber;
	private int customerId;
	private String accountType;
	private String branchAddress;
	private LocalDate createDt;

}
