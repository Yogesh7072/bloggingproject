package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.customException.ResourceNotFoundException;
import com.example.demo.dto.CategoryDto;
import com.example.demo.model.Category;
import com.example.demo.repositry.CategoryRepositry;

@Repository
public class CategoryDao {
	@Autowired
	private ModelMapper map;
	@Autowired
	private CategoryRepositry categoryRepo;

	public CategoryDto saveCategory(CategoryDto dto) {
		// TODO Auto-generated method stub

		Category category = map.map(dto, Category.class);

		Category save = categoryRepo.save(category);
		CategoryDto categoryDto = map.map(save, CategoryDto.class);

		return categoryDto;
	}

	public CategoryDto updateCategory(CategoryDto dto) {
		// TODO Auto-generated method stub
		try {
			Category category = map.map(dto, Category.class);
			Category save = categoryRepo.save(category);
			CategoryDto categoryDto = map.map(save, CategoryDto.class);

			return categoryDto;
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}
	}

	public CategoryDto getCategory(Integer catagoryId) {
		// TODO Auto-generated method stub

		Optional<Category> findById = categoryRepo.findById(catagoryId);

		if (findById != null) {
			Category category = findById.get();
			CategoryDto categoryDto = map.map(category, CategoryDto.class);
			return categoryDto;
		} else {
			throw new ResourceNotFoundException("Category", " ID :  ", catagoryId);
		}

	}

	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		ArrayList<Category> findAll = (ArrayList<Category>) categoryRepo.findAll();

		ArrayList<CategoryDto> list = new ArrayList<CategoryDto>();

		for (Category categoryDto : findAll) {
			CategoryDto map2 = map.map(categoryDto, CategoryDto.class);

			list.add(map2);
		}
		return list;
	}

	public void deletecategory(Integer categoryId) {
		// TODO Auto-generated method stub

		categoryRepo.findById(categoryId).orElseThrow(
				() -> new ResourceNotFoundException("catagery not present on database ", "id  :  ", categoryId));
		categoryRepo.deleteById(categoryId);

	}

}
