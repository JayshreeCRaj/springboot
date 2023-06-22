package com.springmicroservices.services;

import java.util.List;

import com.springmicroservices.models.Cards;
import com.springmicroservices.responses.LoansDetails;

public interface ICards {
	
	public List<Cards> getCardsDetails(int customerId);

	public LoansDetails fetchLoansDetails(int customerId);

}
