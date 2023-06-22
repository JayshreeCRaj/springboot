package com.springmicroservices.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmicroservices.exceptions.CustomerNotFoundException;
import com.springmicroservices.models.Customer;
import com.springmicroservices.repositories.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements ICustomer{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		log.info("CustomerService -> Create customer information in database");
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(int customerId, Customer inputCustomer) {
		log.info("CustomerService -> Update customer information in database");
		Customer customer = getCustomerDetails(customerId);
		
		log.info("Database value: {}", customer.getName());
		if (inputCustomer.getName() != null) {
			customer.setName(inputCustomer.getName());
			log.info("Updated value: {}", customer.getMobileNumber());
			customer = customerRepository.save(customer);
		}
		
		log.info("Database value: {}", customer.getEmail());
		if (inputCustomer.getEmail() != null) {
			customer.setEmail(inputCustomer.getEmail());
			log.info("Updated value: {}", customer.getMobileNumber());
			customer = customerRepository.save(customer);
		}
		
		log.info("Database value: {}", customer.getMobileNumber());
		if (inputCustomer.getMobileNumber() != null) {
			customer.setMobileNumber(inputCustomer.getMobileNumber());
			log.info("Updated value: {}", customer.getMobileNumber());
			customer = customerRepository.save(customer);
		}

		return customer;

	}

	@Override
	public void deleteCustomer(int customerId) {
		log.info("CustomerService -> Delete customer information from database");
		Customer customer = getCustomerDetails(customerId);
		customerRepository.deleteById(customer.getCustomerId());
		
	}

	@Override
	public Customer getCustomerDetails(int customerId) {
		
		log.info("CustomerService -> Get customer information from database");
		Optional<Customer> optional = customerRepository.findById(customerId);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		else {
			
			log.error("Customer Details Not Found");
			throw new CustomerNotFoundException("Customer Details Not Found");
		}
	}

}
