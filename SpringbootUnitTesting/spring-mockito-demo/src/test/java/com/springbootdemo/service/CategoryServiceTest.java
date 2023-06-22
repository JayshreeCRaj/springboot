package com.springbootdemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.springbootdemo.exception.CategoryNotFoundException;
import com.springbootdemo.models.Category;
import com.springbootdemo.repositories.CategoryRepository;

@ExtendWith(SpringExtension.class)
public class CategoryServiceTest {
	
	@InjectMocks
	CategoryServiceImpl categoryService;
	
	@Mock
	CategoryRepository categoryRepository;
	
	@Test
	@DisplayName("Test Create Category 1")
	public void createCategoryTest1() {
		
		Category category = new Category();
		category.setCName("Jewelry");
		category.setCId(321);
		
		Category dbCategory = new Category();
		dbCategory.setCName("Jewelry");
		dbCategory.setCId(321);
		/*Mockito.when(categoryRepository.save(ArgumentMatchers.any(Category.class)))
		.thenReturn(dbCategory);*/
		Mockito.when(categoryRepository.save(category)).thenReturn(dbCategory);
		var dbResult= categoryService.createCategory(category);
		assertEquals(dbResult.getCName(), category.getCName());
		assertNotNull(dbCategory.getCId());
		
	}
	
	//BDD method naming convention makes the code more readable 
	//BDD Test
	//When
		//Then
			//Given
	@Test
	@DisplayName("Test Create Category 2")
	public void When_Create_Category_With_ValidInput_Then_Return_InvalidData() {
		
		Category category = new Category();
		category.setCName("Jewelry");
		category.setCId(476);
		
		Category dbCategory = new Category();
		dbCategory.setCName("Mobile");
		dbCategory.setCId(476);
		Mockito.when(categoryRepository.save(ArgumentMatchers.any(Category.class)))
		.thenReturn(dbCategory);
		var dbResult= categoryService.createCategory(category);
		assertNotEquals(dbResult.getCName(), category.getCName());
		
	}
	
	@Test
	@DisplayName("Test Create Category 3")
	public void When_Create_Category_With_InvalidName_Then_Throw_Exception(){
		
		Category category = new Category();
		category.setCId(null);
		
		Category dbCategory = new Category();
		dbCategory.setCId(null);
		Mockito.when(categoryRepository.save(ArgumentMatchers.any(Category.class)))
		.thenReturn(dbCategory);
		assertThrows(CategoryNotFoundException.class, ()->categoryService.createCategory(category));
		
	}
	
	@Test
	@DisplayName("Test Fetch all category")
	//@Disabled
	public void fetchAllCategoryTest() {
		Mockito.when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
		var result = categoryService.fetchAllCategory();
		assertEquals(result, new ArrayList<>());
	}
	
	@Test
	@DisplayName("Test get single category")
	public void retrieveSingleCategory() {
		Category category = new Category();
		category.setCId(555);
		Mockito.when(categoryRepository.findById(ArgumentMatchers.anyInt())).
		thenReturn(Optional.of(category));
		Category dbCategory = categoryService.retrieveSingleCategory(555);
		assertEquals(dbCategory.getCName(), category.getCName());
	}
	
	@Test
	@DisplayName("Test get single category for null")
	public void retrieveSingleCategoryNull() {
		Category category = new Category();
		category.setCId(555);
		//Mockito.when(categoryRepository.findById(ArgumentMatchers.anyInt())).
		//thenReturn(Optional.ofNullable(null));
		//assertThatExceptionOfType(CategoryNotFoundException.class).isThrownBy(()->categoryService.retrieveSingleCategory(555));
		assertThrows(CategoryNotFoundException.class, ()->categoryService.retrieveSingleCategory(555));
		
	}
	
	@Test
	@DisplayName("Test delete category")
	public void deleteCategory() {
		Category category = new Category();
		category.setCId(555);
		Mockito.when(categoryRepository.findById(ArgumentMatchers.anyInt())).
		thenReturn(Optional.of(category));
		doNothing().when(categoryRepository).
		delete(ArgumentMatchers.any(Category.class));
		categoryService.deleteCategory(555);
	}
}
