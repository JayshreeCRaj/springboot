package com.springbootdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.exception.CategoryNotFoundException;
import com.springbootdemo.models.Category;
import com.springbootdemo.repositories.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements ICategory{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category category) {
		if(category.getCId() == null) {
			log.error("Category id not provided");
			throw new CategoryNotFoundException("Category Not Found Exception");
		}
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Integer categoryId, Category inputCategory) {
		Category category = retrieveSingleCategory(categoryId);
		category.setCName(inputCategory.getCName());
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Integer cId) {
		Category category = retrieveSingleCategory(cId);
			categoryRepository.deleteById(category.getCId());
		
	}

	@Override
	public Category retrieveSingleCategory(Integer cId) {
		Optional<Category> optional = categoryRepository.findById(cId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else
			log.error("Category not found exception {}", cId);
			throw new CategoryNotFoundException("Category Not Found Exception");
	}

	@Override
	public Iterable<Category> fetchAllCategory() {
		return categoryRepository.findAll();
	}

}
