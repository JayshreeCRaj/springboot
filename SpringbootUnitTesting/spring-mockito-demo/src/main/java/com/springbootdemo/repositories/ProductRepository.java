package com.springbootdemo.repositories;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootdemo.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	//add custom methods to define a query
	//Select * from Product where name=""
	Product findBypName(String productName);
	
	//Select * from Product where price=
	Product findByPrice(Double price);
	
	//Select * from Product where name= "" and price=
	Product findBypNameAndPrice(String productName, Double price);
	
	List<Product> findBypNameContaining(String pname);
	
	Stream<Product> findByPriceLessThan(Double price);
	
	List<Product> findByPriceGreaterThan(Double price);
	
	//List<Product> findByPriceOrderBypNameDesc(Double price);
	
	//List<Product> findByPriceOrderBypNameAsc(Double price);
	
	
	
	

}
