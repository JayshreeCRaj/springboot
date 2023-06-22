package com.springbootdemo.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.springbootdemo.models.Product;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ProductServiceImpl implements IProduct {
	
	@Autowired
	private KafkaTemplate<String, Product> kafkaTemplate;

	@Override
	public String publishProduct() {
		
		for(int i=1; i<=10; i++) {
			Product product = new Product();
			product.setPId(UUID.randomUUID());
			product.setActive(true);
			product.setPName("IPhone-"+i);
			product.setCreatedTime(new Date());
			product.setUpdatedTime(new Date());
			product.setPrice(30000d+(i*10000)-i);
			
			try {
				Thread.sleep(500);
				kafkaTemplate.send("AppleProducts", product);
				log.info("Message Published to kafka Topic {}",product.getPId());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return "Product added to kafka topic successfully";
	}
	
	
}
