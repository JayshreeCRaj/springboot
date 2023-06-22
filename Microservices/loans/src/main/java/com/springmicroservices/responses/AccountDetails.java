package com.springmicroservices.responses;

import java.util.List;

import com.springmicroservices.models.Loans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDetails {
	
	private Account account;
	private List <Loans> loans;

}
