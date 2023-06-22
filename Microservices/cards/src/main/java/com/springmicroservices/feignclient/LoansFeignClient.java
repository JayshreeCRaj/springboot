package com.springmicroservices.feignclient;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springmicroservices.responses.Loans;

@FeignClient("loans")
@LoadBalancerClient("loans")
public interface LoansFeignClient {

	@GetMapping("/api/v1/loans/{customerId}")
	public List<Loans> getLoansDetails(@PathVariable("customerId") int customerId);
	
}
