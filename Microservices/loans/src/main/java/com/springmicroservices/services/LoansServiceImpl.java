package com.springmicroservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmicroservices.exceptions.LoanNotFoundException;
import com.springmicroservices.feignclients.AccountFeignClient;
import com.springmicroservices.models.Loans;
import com.springmicroservices.repositories.LoansRepository;
import com.springmicroservices.responses.AccountDetails;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoansServiceImpl implements ILoans{
	
	@Autowired
	private LoansRepository loansRepository;
	
	@Autowired
	private AccountFeignClient accountFeignClient;

	@Override
	public List<Loans> getLoansDetails(int customerId) {
		log.info("LoansService -> Get loans information from database");
		List<Loans> loans = loansRepository.findByCustomerId(customerId);
		if(loans != null) {
			return loans;
		}
		else {
			log.error("Loans Not Found Exception");
			throw new LoanNotFoundException("Loans Not Found Exception");
		}
	}
	
	@Override
	public AccountDetails fetchAccountDetails(int customerId) {
		log.info("AccountDetails -> Get Account information from database");
		var accounts = accountFeignClient.getAccountDetails(customerId);
		log.info("Accounts Response {} ", accounts);
		log.info("LoansDetails -> Get Loans information from database");
		var loans = getLoansDetails(customerId);
		log.info("Loans Response {} ", loans);
		return new AccountDetails(accounts, loans);
	}

}
