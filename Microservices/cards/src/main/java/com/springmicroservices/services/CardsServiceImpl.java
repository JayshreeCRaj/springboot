package com.springmicroservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmicroservices.exceptions.CardNotFoundException;
import com.springmicroservices.feignclient.AccountFeignClient;
import com.springmicroservices.feignclient.LoansFeignClient;
import com.springmicroservices.models.Cards;
import com.springmicroservices.repositories.CardsRepository;
import com.springmicroservices.responses.LoansDetails;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CardsServiceImpl implements ICards {
	
	@Autowired
	private CardsRepository cardsRepository;
	
	@Autowired
	private AccountFeignClient accountFeignClient;
	
	@Autowired
	private LoansFeignClient loansFeignClient;

	@Override
	public List<Cards> getCardsDetails(int customerId) {
		log.info("CardsService -> Get cards information from database");
		List<Cards> cards = cardsRepository.findByCustomerId(customerId);
		if(cards != null) {
			return cards;
		}
		else {
			log.error("Cards Not Found Exception");
			throw new CardNotFoundException("Cards Not Found Exception");
		}
	}
	
	@Override
	public LoansDetails fetchLoansDetails(int customerId) {
		log.info("CustomerDetails -> Get customer information from database");
		var accounts = accountFeignClient.getAccountDetails(customerId);
		log.info("Accounts Response {} ", accounts);
		log.info("CardsDetails -> Get Cards information from database");
		var cards = getCardsDetails(customerId);
		log.info("Cards Response {} ", cards);
		log.info("LoansDetails -> Get Loans information from database");
		var loans = loansFeignClient.getLoansDetails(customerId);
		log.info("Loans Response {} ", loans);
		return new LoansDetails(accounts, cards, loans);
	}

}
