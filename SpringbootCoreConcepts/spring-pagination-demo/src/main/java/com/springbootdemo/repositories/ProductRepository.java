package com.springbootdemo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootdemo.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	//JPQL - using a high-level, object-oriented syntax
	@Query(value="select p from Product p where p.pName =:pname")
	Product getProductsUsingName(String pname);
	
	//Get Products using native query
	@Query(value="select * from Product p where p.pName =:pname", nativeQuery=true)
	Product getProductsUsingNativeQuery(String pname);
	
	@Query(value="select p from Product p where p.pName =:pname and p.price =:price")
	Product getProductUsingNameAndPrice(String pname, Double price);
	
	@Query(value="select p from Product p where p.pName = ?1 and p.price = ?2")
	Product getProductUsingNameAndPrice1(String pname, Double price);
	
	@Query(value="select p from Product p INNER JOIN Category c ON p.id = c.id")
	List<Product> getProductJoinOnCategory();
	
	@Query(value="select p from Product p where p.pName LIKE %?1%")
	List<Product> getProductUsingKeyword(String pname);
	
	@Transactional
	@Query(value="UPDATE Product p SET p.active = ?2 where p.id = ?1")
	@Modifying
	public void updateProductStatus(Integer pId, Boolean activeStatus);
	
	
	
	
	
	
	
	

}
