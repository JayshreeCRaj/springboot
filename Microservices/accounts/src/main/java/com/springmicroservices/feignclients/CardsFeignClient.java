package com.springmicroservices.feignclients;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springmicroservices.responses.Cards;

@FeignClient("cards")
@LoadBalancerClient("cards")
public interface CardsFeignClient {
	
	@GetMapping("/api/v1/cards/{customerId}")
	public List<Cards> getCardsDetails(@PathVariable("customerId") int customerId);

}
