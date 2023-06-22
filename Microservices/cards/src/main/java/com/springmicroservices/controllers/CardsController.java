package com.springmicroservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmicroservices.models.Cards;
import com.springmicroservices.responses.LoansDetails;
import com.springmicroservices.services.ICards;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/cards")
public class CardsController {
	
	@Autowired
	private ICards iCards;
	
	@GetMapping("/{customerId}")
	public List<Cards> getCardsDetails(@PathVariable("customerId") int customerId) {
		log.info("Cards Contoller -> getCardsDetails {} ", customerId);
		return iCards.getCardsDetails(customerId);
	}
	
	@GetMapping("customerinfo/{customerId}")
	public LoansDetails fetchLoansDetails(@PathVariable("customerId") int customerId ) {
		log.info("Cards Contoller -> fetchLoansDetails {} ", customerId);
		return iCards.fetchLoansDetails(customerId);
	}


}
