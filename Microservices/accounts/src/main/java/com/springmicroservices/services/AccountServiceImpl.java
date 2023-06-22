package com.springmicroservices.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmicroservices.config.AccountsConfig;
import com.springmicroservices.exceptions.AccountNotExistException;
import com.springmicroservices.feignclients.CardsFeignClient;
import com.springmicroservices.feignclients.LoansFeignClient;
import com.springmicroservices.models.Account;
import com.springmicroservices.repositories.AccountRepository;
import com.springmicroservices.responses.CustomerDetails;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountServiceImpl implements IAccount {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CardsFeignClient cardsFeignClient;
	
	@Autowired
	private LoansFeignClient loansFeignClient;
	
	@Autowired
	private AccountsConfig accountsConfig;
	
	@Override
	public Account createAccount(Account account) {
		log.info("AccountService -> Create account information in database");
		return accountRepository.save(account);
	}
	
	@Override
	public Account updateAccount(int customerId, Account inputAccount) {
		
		log.info("AccountService -> Update account information in database");
		Account account = getAccountDetails(customerId);
		
		log.info("Database value: {}", account.getAccountType());
		if(inputAccount.getAccountType() != null)  {
			account.setAccountType(inputAccount.getAccountType());
			log.info("Updated value: {}", account.getAccountType());
			account = accountRepository.save(account);	
		}
		
		log.info("Database value: {}", account.getBranchAddress());
		if(inputAccount.getBranchAddress() != null) {
			account.setBranchAddress(inputAccount.getBranchAddress());
			log.info("Updated value: {}", account.getBranchAddress());
			account = accountRepository.save(account);
		}
		
		return account;
			
	}

	@Override
	public void deleteAccount(int customerId) {
		
		Account account = getAccountDetails(customerId);
		log.info("AccountService -> Delete account information from database");
		accountRepository.deleteByCustomerId(account.getCustomerId());
		
	}

	@Override
	public Account getAccountDetails(int customerId) {
		
		log.info("AccountService -> Get account information from database");
		Optional<Account> optional = accountRepository.findByCustomerId(customerId);
		if(optional.isPresent()) {
			return optional.get() ;
		}
		else {
			log.error("Account Not Found Exception");
			throw new AccountNotExistException("Account Not Found Exception");
		}
		
	}

	@Override
	//@CircuitBreaker(name="customer-info", fallbackMethod="fetchCustomerDetails_FallBack")
	@Retry(name="customer-retry", fallbackMethod="fetchCustomerDetails_FallBack")
	public CustomerDetails fetchCustomerDetails(int customerId) {
		log.info("CustomerDetails -> Get customer information from database");
		var accounts = getAccountDetails(customerId);
		log.info("Accounts Response {} ", accounts);
		var cards = cardsFeignClient.getCardsDetails(customerId);
		log.info("Cards Response {} ", cards);
		var loans = loansFeignClient.getLoansDetails(customerId);
		log.info("Loans Response {} ", loans);
		return new CustomerDetails(accounts, cards, loans, null);
	}
	
	public CustomerDetails fetchCustomerDetails_FallBack(int customerId, Exception ex) {
		log.info("CustomerDetails -> Get customer information from database");
		var accounts = getAccountDetails(customerId);
		log.info("Accounts Response {} ", accounts);
		
		return  new CustomerDetails(accounts, null, null, "Card and Loan Services are Down"); 
		  
	}

	@Override
	public String getLocationDetails() {
		log.info("Accounts Location info {}", accountsConfig.getLocation());
		return accountsConfig.getLocation();
	}

}
