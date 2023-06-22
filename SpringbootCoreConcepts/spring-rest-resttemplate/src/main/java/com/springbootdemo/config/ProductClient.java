package com.springbootdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.springbootdemo.request.Category;
import com.springbootdemo.request.Product;

@Service
public class ProductClient {
	
	@Autowired
	public RestTemplate restTemplate;
	
	public void getDisplayMessage() {
		String url = "http://localhost:8080/api/v1/product/demo";
		ResponseEntity<String> responseEntity= restTemplate.getForEntity(url, String.class);
		
		if(responseEntity.getStatusCode().value() == 200) {
			System.out.println(responseEntity.getBody());
		}
	}
	
	public void createProduct() {
		try {
				String url = "http://localhost:8080/api/v1/product/create";
				
				Product product = new Product();
				product.setPName("Cole Haan Leather");
				product.setActive(true);
				product.setPrice(19000d);
				
				Category category = new Category();
				category.setCId(3);
				
				product.setCategory(category);
				
				HttpHeaders headers = new HttpHeaders();
				headers.set("Accept", "application/json");
				headers.set("Content-Type", "application/json");
				
				HttpEntity<Product> httpEntity = new HttpEntity<Product>(product, headers);
				
				ResponseEntity<Product> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Product.class);
				
				if(responseEntity.getStatusCode().value() == 200) {
					System.out.println(responseEntity.getBody());
				}
				
		}catch (HttpClientErrorException ex) {
			ex.getMessage();
		}catch (ResourceAccessException ex) {
			ex.getMessage();
		}catch (Exception e) {
			System.out.println("Something went Wrong while accessing URL"+e.getLocalizedMessage());
		}
		
		
		
	}
	

}
