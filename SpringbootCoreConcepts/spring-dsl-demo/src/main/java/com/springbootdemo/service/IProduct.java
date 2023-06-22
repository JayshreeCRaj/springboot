package com.springbootdemo.service;

import com.springbootdemo.models.Product;

public interface IProduct {
	
	public Product createProduct(Product product);
	public Product updateProduct(Integer productId, Product product);
	public void deleteProduct(Integer productId);
	public void deleteAllProduct();
	public Product retrieveSingleProduct(Integer productId);
	public Iterable<Product> retriveAllProduct();
	

}
