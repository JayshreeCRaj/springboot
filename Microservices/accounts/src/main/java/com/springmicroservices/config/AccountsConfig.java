package com.springmicroservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "accounts")
@Data
public class AccountsConfig {
	
	private String location;
	private String branchName;
}
