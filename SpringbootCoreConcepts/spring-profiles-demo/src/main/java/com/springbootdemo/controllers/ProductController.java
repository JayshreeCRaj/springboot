package com.springbootdemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.models.Product;
import com.springbootdemo.service.IProduct;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	//@Autowired
	//private ProductServiceImpl productService;
	
	@Autowired
	private IProduct iProduct;
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody @Valid Product product) {
		return iProduct.createProduct(product);	
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable("id") Integer productId) {
		iProduct.deleteProduct(productId);
		
		
	}

	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable("id") Integer productId, @RequestBody Product inputProduct) {
		// TODO Auto-generated method stub;
		return iProduct.updateProduct(productId, inputProduct);
	}
	
	@GetMapping("/retrieveSingle/{id}")
	public Product retrieveSingleProduct(@PathVariable("id") Integer productId) {
		
		return iProduct.retrieveSingleProduct(productId);
	}

	@GetMapping(("/retrieveAll"))
	public Iterable<Product> retriveAllProduct()
	{
		// TODO Auto-generated method stub
		return iProduct.retriveAllProduct();
	}

	@DeleteMapping("/deleteAll")
	public void deleteAllProduct() {
		// TODO Auto-generated method stub
		
		iProduct.deleteAllProduct();
		
	}
	
	
	

}
