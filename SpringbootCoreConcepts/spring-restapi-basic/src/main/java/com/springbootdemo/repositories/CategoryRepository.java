package com.springbootdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootdemo.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

	
	
}
