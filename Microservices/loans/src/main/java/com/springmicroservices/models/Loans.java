package com.springmicroservices.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Loans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loanNumber;
	private int customerId;
	private Date startDt;
	private String loanType;
	private Integer totalLoan;
	private Integer amountPaid;
	private Integer outstandingAmount;
	private String createDt;

}
