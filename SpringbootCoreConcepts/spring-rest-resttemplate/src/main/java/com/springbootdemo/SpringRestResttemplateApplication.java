package com.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springbootdemo.config.ProductClient;

@SpringBootApplication
public class SpringRestResttemplateApplication implements CommandLineRunner {
	
	
	@Autowired
	private ProductClient productClient;
	public static void main(String[] args) {
		SpringApplication.run(SpringRestResttemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//productClient.getDisplayMessage();
		productClient.createProduct();
	}

}
