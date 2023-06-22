package com.springbootdemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.models.Product;
import com.springbootdemo.responses.ProductPageResponse;
import com.springbootdemo.service.IProduct;
import com.springbootdemo.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private IProduct iProduct;
	
	@GetMapping("/demo")
	public String getMessage() {
		return "Rest template demo";
	}
	
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
	
	@GetMapping("/getProductByName/{pname}")
	public Product getProductsUsingName(@PathVariable("pname") String productName) {
		
		return productService.getProductsUsingName(productName);
	}
	
	@GetMapping("/paginationTrack")
	public ProductPageResponse getProductsUsingPagination(
			@RequestParam(value="pageNumber", required = false, defaultValue= "0" )int pageNumber, 
			@RequestParam(value="noOfRecords", required = false, defaultValue= "3" )int noOfRecords, 
			@RequestParam(value="sort", required = false, defaultValue= "ASC" )String sort) {
		
		if(sort.equals("ASC")) {
			return productService.getProductsUsingPagination(PageRequest.of(pageNumber, noOfRecords, Direction.ASC, "pId"));
		}
		else {
			return productService.getProductsUsingPagination(PageRequest.of(pageNumber, noOfRecords, Direction.DESC, "pId")); 
		}
	}
}
