package com.springbootdemo.controllers;

import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootdemo.models.Category;
import com.springbootdemo.service.CategoryServiceImpl;

@ExtendWith(SpringExtension.class)
class CategoryControllerTest {
	
	private static MockMvc mockMvc;
	
	@Mock
	private CategoryServiceImpl categoryService;
	
	@InjectMocks
	private CategoryController categoryController;
	
	@BeforeEach
	public void before() {
		mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
	}

	@Test
	public void createCategoryTest() throws Exception {
		Category category = new Category();
		category.setCName("Mobile");
		ObjectMapper obj = new ObjectMapper();
		Mockito.when(categoryService.createCategory(ArgumentMatchers.any(Category.class))).thenReturn(category);
		categoryController.createCategory(category);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/category/create").
				content(obj.writeValueAsString(category)).
				contentType(MediaType.APPLICATION_JSON_VALUE)).
				andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void When_Create_PostRequest_With_InvalidUri_Then_Return_NotFound() throws Exception {
		ObjectMapper obj = new ObjectMapper();
		mockMvc.perform(MockMvcRequestBuilders.post("/api1/category1/create").
				content(obj.writeValueAsString(null)).
				contentType(MediaType.APPLICATION_JSON_VALUE)).
				andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void fetchAllCategoriesTest() throws Exception {
		Category category = new Category();
		category.setCName("Mobile");
		List<Category> list = new ArrayList<>();
		list.add(category);
		Mockito.when(categoryService.fetchAllCategory()).thenReturn(list);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/category/All")).
				andExpect(MockMvcResultMatchers.status().isOk());
	
	}
	
	@Test
	public void When_Send_GetRequest_With_InvalidUri_Then_Return_NotFound() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api1/category1/All")).
				andExpect(MockMvcResultMatchers.status().isNotFound());
	
	}
	
	@Test
	public void fetchCategoryTest() throws Exception {
		Category category = new Category();
		category.setCName("Mobile");
		Mockito.when(categoryService.retrieveSingleCategory(ArgumentMatchers.anyInt())).
		thenReturn(category);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/category/{id}", 1)).
		andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
	public void deleteCategoryTest() throws Exception {
		doNothing().when(categoryService).deleteCategory(ArgumentMatchers.anyInt());
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/category/{id}", 1)).
		andExpect(MockMvcResultMatchers.status().isOk());

	}

}
