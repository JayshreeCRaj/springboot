package com.springmicroservices.feignclient;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springmicroservices.responses.Account;

@FeignClient("accounts")
@LoadBalancerClient("accounts")
public interface AccountFeignClient {
	
	@GetMapping("/api/v1/accounts/{customerId}")
	public Account getAccountDetails(@PathVariable("customerId") int customerId);

}
