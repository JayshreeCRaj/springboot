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

import com.springmicroservices.models.Customer;
import com.springmicroservices.services.ICustomer;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	@Autowired
	private ICustomer iCustomer;
	
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		log.info("Customer Contoller -> createCustomer {} ", customer);
		return iCustomer.createCustomer(customer);
	}
	
	
	@PutMapping("/{customerId}") 
	public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer){ 
		log.info("Customer Contoller -> updateCustomer {} ", customerId); 
		return iCustomer.updateCustomer(customerId, customer); 
	}
	 
	
	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") int customerId) {
		log.info("Customer Contoller -> deleteCustomer {} ", customerId);
		iCustomer.deleteCustomer(customerId);
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomerDetails(@PathVariable("customerId") int customerId) {
		log.info("Customer Contoller -> getCustomerDetails {} ", customerId);
		return iCustomer.getCustomerDetails(customerId);
	}
	

}
