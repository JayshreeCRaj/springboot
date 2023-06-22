package com.springbootdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootdemo.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
