package com.springmicroservices.services;

import com.springmicroservices.models.Account;
import com.springmicroservices.responses.CustomerDetails;

public interface IAccount {
	
	public Account createAccount(Account account);
	public Account updateAccount(int customerId, Account account);
	public void deleteAccount(int customerId);
	public Account getAccountDetails(int customerId);
	public CustomerDetails fetchCustomerDetails(int customerId);
	public String getLocationDetails();
	
}
