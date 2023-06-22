package com.springbootdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.models.Category;
import com.springbootdemo.models.Product;
import com.springbootdemo.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements IProduct {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ICategory icategory;
	
	@Override
	public Product createProduct(Product product) {
		Category dbCategory=icategory.retrieveSingleCategory(product.getCategory().getCId());
		product.setCategory(dbCategory);
		return productRepository.save(product);
		
	}

	@Override
	public Product updateProduct(Integer productId, Product inputProduct) {
		// TODO Auto-generated method stub;
		Product product = retrieveSingleProduct(productId);
		product.setPName(inputProduct.getPName());
		product.setPrice(inputProduct.getPrice());
		product.setActive(inputProduct.getActive());
		product.setCategory(inputProduct.getCategory());
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer productId) {
		Product product = retrieveSingleProduct(productId);
		productRepository.deleteById(product.getPId());
		
	}

	@Override
	public Product retrieveSingleProduct(Integer productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else
			throw new RuntimeException("Product not found exception");
		
	}

	@Override
	public Iterable<Product> retriveAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public void deleteAllProduct() {
		// TODO Auto-generated method stub
		
		productRepository.deleteAll();
		
	}
	
	
}
