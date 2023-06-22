package com.springmicroservices.services;

import java.util.List;

import com.springmicroservices.models.Loans;
import com.springmicroservices.responses.AccountDetails;

public interface ILoans {
	
	public List<Loans> getLoansDetails(int customerId);

	AccountDetails fetchAccountDetails(int customerId);

}
