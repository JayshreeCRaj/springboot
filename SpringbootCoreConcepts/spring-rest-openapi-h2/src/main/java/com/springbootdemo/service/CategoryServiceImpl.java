package com.springbootdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.models.Category;
import com.springbootdemo.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements ICategory{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Integer categoryId, Category inputCategory) {
		// TODO Auto-generated method stub
		Category category = retrieveSingleCategory(categoryId);
		category.setCName(inputCategory.getCName());
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Integer cId) {
		// TODO Auto-generated method stub
		Category category = retrieveSingleCategory(cId);
			categoryRepository.deleteById(category.getCId());
		
	}

	@Override
	public Category retrieveSingleCategory(Integer cId) {
		// TODO Auto-generated method stub
		Optional<Category> optional = categoryRepository.findById(cId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else
			throw new RuntimeException("Category Not Found Exception");
	}

	@Override
	public Iterable<Category> fetchAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

}
