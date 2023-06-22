package com.springbootdemo.responses;

import java.util.List;

import com.springbootdemo.models.Product;

public class ProductPageResponse {
	
	int totalPageNumer;
	int totalNoOfElements;
	List<Product> products;
	
	public ProductPageResponse() {
		//Default Constructor
	}
	
	public int getTotalPageNumer() {
		return totalPageNumer;
	}
	public void setTotalPageNumer(int totalPageNumer) {
		this.totalPageNumer = totalPageNumer;
	}
	public int getTotalNoOfElements() {
		return totalNoOfElements;
	}
	public void setTotalNoOfElements(int totalNoOfElements) {
		this.totalNoOfElements = totalNoOfElements;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "ProductPageResponse [totalPageNumer=" + totalPageNumer + ", totalNoOfElements=" + totalNoOfElements
				+ ", products=" + products + "]";
	}
	
	
}
