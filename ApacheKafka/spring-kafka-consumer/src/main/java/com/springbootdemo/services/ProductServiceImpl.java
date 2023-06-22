package com.springbootdemo.services;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.springbootdemo.listenermodels.Product;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ProductServiceImpl implements IProduct {
	
	@Override
	@KafkaListener(topics = "AppleProducts", groupId="Consume_Products" )
	public void consumeProduct(@Payload List<Product> product) {
		log.info("Received Original Message as {} ::", product);
	}
	
}
