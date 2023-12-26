package com.example.demo.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.CategoryDao;
import com.example.demo.dto.CategoryDto;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	/**
	 * @note this method call to dao class and save the object its new created
	 *       category object
	 * 
	 * @see CategoryDto its boject this is new object
	 * 
	 * @see in this method call to save catagery method and in catagory dao
	 * 
	 * @author yogeshwar chate v3.5
	 * 
	 */
	@Override
	public CategoryDto createCategory(CategoryDto dto) {
		CategoryDto category = categoryDao.saveCategory(dto);
		return category;
	}

	/**
	 * @note this method used to update catagery object
	 * 
	 * @see dto is a updated object boject its replace to old database object using
	 *      getter setter
	 * 
	 * @see oldObjectcategoryDto old object present in databse
	 * 
	 * @author yogeshwar chate v3.5
	 * 
	 */

	@Override
	public CategoryDto updateCategory(CategoryDto dto, Integer catagoryId) {
		System.out.println("updatedCategory start  : " + dto);

		CategoryDto oldObjectcategoryDto = categoryDao.getCategory(catagoryId);
		System.out.println("oldObjectcategoryDto   : " + oldObjectcategoryDto);

		oldObjectcategoryDto.setCategoryTitle(dto.getCategoryTitle());
		oldObjectcategoryDto.setCategoryDiscription(dto.getCategoryDiscription());
		CategoryDto updatedCategoryObject = categoryDao.updateCategory(oldObjectcategoryDto);

		System.out.println("updatedCategoryObject  : " + updatedCategoryObject);
		return updatedCategoryObject;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub

		categoryDao.deletecategory(categoryId);

	}

	@Override
	public CategoryDto getCategory(Integer catagoryId) {
		// TODO Auto-generated method stub

		CategoryDto category = categoryDao.getCategory(catagoryId);

		return category;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		List<CategoryDto> category = categoryDao.getAllCategory();

		return category;
	}

}
