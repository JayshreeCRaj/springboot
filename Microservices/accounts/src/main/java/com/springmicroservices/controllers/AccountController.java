package com.springmicroservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.springmicroservices.feignclients.CardsFeignClient;
import com.springmicroservices.models.Account;
import com.springmicroservices.responses.CustomerDetails;
import com.springmicroservices.services.IAccount;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/accounts")
public class AccountController {
	
	@Autowired
	private IAccount iAccount;
	
	/*
	 * @Autowired private CardsFeignClient cardsFeignClient;
	 */
	
	@PostMapping
	public Account createAccount(@RequestBody Account account) {
		log.info("Account Contoller -> createAccount {} ", account);
		return iAccount.createAccount(account);
	}
	
	@PutMapping("/{customerId}")
	public Account updateAccount(@PathVariable("customerId") int customerId, @RequestBody Account account) {
		log.info("Account Contoller -> updateAccount {} ", customerId);
		return iAccount.updateAccount(customerId, account);
	}
	
	@DeleteMapping("/{customerId}")
	public void deleteAccount(@PathVariable("customerId") int customerId) {
		log.info("Account Contoller -> deleteAccount {} ", customerId);
		iAccount.deleteAccount(customerId);
	}
	
	@GetMapping("/{customerId}")
	public Account getAccountDetails(@PathVariable("customerId") int customerId) {
		log.info("Account Contoller -> getAccountDetails {} ", customerId);
		return iAccount.getAccountDetails(customerId);
	}
	
	@GetMapping("customerinfo/{customerId}")
	public CustomerDetails fetchCustomerDetails(@PathVariable("customerId") int customerId ) {
		log.info("Account Contoller -> fetchCustomerDetails {} ", customerId);
		return iAccount.fetchCustomerDetails(customerId);
	}
	
	@GetMapping("/location")
	public String getLocationDetails() {
		log.info("Account Contoller -> getLocationDetails ");
		return iAccount.getLocationDetails();
	}

}
