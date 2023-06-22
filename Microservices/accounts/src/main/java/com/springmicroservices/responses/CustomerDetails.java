package com.springmicroservices.responses;

import java.util.List;

import com.springmicroservices.models.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {
	
	private Account account;
	private List <Cards> cards;
	private List <Loans> loans;
	private String errorMessage;

}
