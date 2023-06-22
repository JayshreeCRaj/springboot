package com.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.models.Category;
import com.springbootdemo.service.ICategory;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private ICategory iCategory;
	
	@PostMapping("/create")
	public Category createCategory(@RequestBody Category inputCategory) {
		return iCategory.createCategory(inputCategory);
	}
	
	@GetMapping("/All")
	public Iterable<Category> fetchAllCategories() {
		return iCategory.fetchAllCategory();
	}
	
	@GetMapping("/{id}")
	public Category fetchCategory(@PathVariable("id") Integer categoryId) {
		return iCategory.retrieveSingleCategory(categoryId);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable("id") Integer categoryId) {
		// TODO Auto-generated method stub
			iCategory.deleteCategory(categoryId);
		
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable("id") Integer categoryId,
							@RequestBody Category inputCategory) {
		return iCategory.updateCategory(categoryId, inputCategory);
	}

}
