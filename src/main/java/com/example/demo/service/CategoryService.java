package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CategoryDto;
import com.example.demo.model.Category;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto dto);

	CategoryDto updateCategory(CategoryDto dto, Integer catagoryId);
	//void deleteCategory(CategoryDto dto);
	

	CategoryDto getCategory(Integer catagoryId);
	
	List<CategoryDto> getAllCategory();

	void deleteCategory(Integer dto);

}
