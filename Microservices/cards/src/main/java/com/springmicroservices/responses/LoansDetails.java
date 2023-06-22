package com.springmicroservices.responses;

import java.util.List;

import com.springmicroservices.models.Cards;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoansDetails {
	
	private Account account;
	private List <Cards> cards;
	private List <Loans> loans;
	
}
