package com.springmicroservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmicroservices.models.Loans;
import com.springmicroservices.responses.AccountDetails;
import com.springmicroservices.services.ILoans;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/loans")
public class LoansController {
	
	@Autowired
	private ILoans iLoans;
	
	@GetMapping("/{customerId}")
	public List<Loans> getLoansDetails(@PathVariable("customerId") int customerId) {
		log.info("Loans Contoller -> getLoansDetails {} ", customerId);
		return iLoans.getLoansDetails(customerId);
	}
	
	@GetMapping("accountinfo/{customerId}")
	public AccountDetails fetchAccountDetails(@PathVariable("customerId") int customerId) {
		log.info("Loans Contoller -> fetchAccountDetails {} ", customerId);
		return iLoans.fetchAccountDetails(customerId);
	
	}

}
