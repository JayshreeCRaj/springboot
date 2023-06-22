package com.springmicroservices.services;

import com.springmicroservices.models.Customer;

public interface ICustomer {

	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(int customerId, Customer customer);
	public void deleteCustomer(int customerId);
	public Customer getCustomerDetails(int customerId);
	
}
