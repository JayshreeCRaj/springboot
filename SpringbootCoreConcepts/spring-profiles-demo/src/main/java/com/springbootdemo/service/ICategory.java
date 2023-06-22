package com.springbootdemo.service;

import com.springbootdemo.models.Category;

public interface ICategory {
	
	public Category createCategory(Category category) ;
	public Category updateCategory(Integer categoryId, Category category);
	public void deleteCategory(Integer cId);
	public Category retrieveSingleCategory(Integer cId);
	public Iterable<Category> fetchAllCategory();

}
