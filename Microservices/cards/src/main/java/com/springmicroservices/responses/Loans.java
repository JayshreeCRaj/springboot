package com.springmicroservices.responses;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Loans {
	
	private Integer loanNumber;
	private int customerId;
	private Date startDt;
	private String loanType;
	private Integer totalLoan;
	private Integer amountPaid;
	private Integer outstandingAmount;
	private String createDt;

}
