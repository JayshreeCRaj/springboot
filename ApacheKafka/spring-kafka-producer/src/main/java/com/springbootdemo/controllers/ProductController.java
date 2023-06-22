package com.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.services.IProduct;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	//@Autowired
	//private ProductServiceImpl productService;
	
	@Autowired
	private IProduct iProduct;
	

	@GetMapping(("/publish"))
	public String publishProduct()
	{
		// TODO Auto-generated method stub
		return iProduct.publishProduct();
	}
	
}
