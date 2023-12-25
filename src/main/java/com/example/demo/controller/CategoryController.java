package com.example.demo.controller;

import java.util.List;

import javax.validation.constraints.Null;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.apiConstant.Apiconstants;
import com.example.demo.apiConstant.URIConstant;
import com.example.demo.apiResponse.ApiResponse;
import com.example.demo.customException.ResourceNotFoundException;
import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;

@RestController
public class CategoryController {

	Logger log = Logger.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	/**
	 * @author yogeshwar chate
	 * @apiNote this api represent the create new category
	 * @see binding with @PostMapping
	 * @see call create object categoryService and call createCategory
	 * @return added category
	 */

	@PostMapping(URIConstant.URI_CATEGORY)
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto dto) {
		CategoryDto createCategory = categoryService.createCategory(dto);
		if (createCategory != null) {
			log.info("createCategory response :  CategoryController  :  " + createCategory);

			return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.ACCEPTED);

		} else {
			log.error("updated response :  CategoryController is  :  " + createCategory);

			throw new ResourceNotFoundException(Apiconstants.CATEGORY_NOT_SAVE, Apiconstants.NOT_FOUND, 0);

		}
	}

	/**
	 * @author yogeshwar chate
	 * @apiNote this api represent the update category
	 * @see binding with @putMapping
	 * @see call create object categoryService and call updateCategory
	 * @return updated category
	 */

	@PutMapping(URIConstant.URI_CATEGORY + "/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto category,
	        @PathVariable("categoryId") Integer categoryId) {
	   
		CategoryDto updateCategory = categoryService.updateCategory(category, categoryId);

		if (updateCategory != null) {
			log.info("updated response :  CategoryController  :  " + updateCategory);

			return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.ACCEPTED);

		} else {
			log.error("updated response :  CategoryController is  :  " + updateCategory);

			throw new ResourceNotFoundException(Apiconstants.CATEGORY_NOT_FOUND, Apiconstants.NOT_FOUND, categoryId);

		}

	}

	/**
	 * @author yogeshwar chate
	 * @apiNote this api represent the delete category
	 * @see binding with @DeleteMapping
	 * @see
	 * @return void
	 */

	@DeleteMapping(URIConstant.URI_CATEGORY + URIConstant.URI_CATEGORY_Id)
	public ResponseEntity<ApiResponse> deleteCategory(Integer categoryId) {
		log.info("deleteCategory start :  CategoryController  :  " + categoryId);
		categoryService.deleteCategory(categoryId);
		log.info("deleteCategory end :  CategoryController  :  " + categoryId);

		return new ResponseEntity<ApiResponse>(new ApiResponse(Apiconstants.DELETE, true), HttpStatus.ACCEPTED);
	}

	/**
	 * @author yogeshwar chate
	 * @apiNote this api represent the get category
	 * @see binding with @GetMapping
	 * @see
	 * @return category
	 * @see if not present category in database then throw exception
	 *      ResourceNotFoundException
	 */
	@GetMapping(URIConstant.URI_CATEGORY + URIConstant.URI_CATEGORY_Id)
	public ResponseEntity<CategoryDto> getCategoryById(Integer categoryId) {
		log.info("getCategoryById start :  CategoryController  :  " + categoryId);
		CategoryDto category = categoryService.getCategory(categoryId);
		if (category != null)
			return new ResponseEntity<CategoryDto>(category, HttpStatus.ACCEPTED);
		else
			throw new ResourceNotFoundException(Apiconstants.CATEGORY_NOT_FOUND, Apiconstants.NOT_FOUND, categoryId);

	}

	/**
	 * @author yogeshwar chate
	 * @apiNote this api represent the getAll categories
	 * @see binding with @GetMapping
	 * @see
	 * @return All category in list
	 * @see if not present category in database then throw exception null pointer
	 *      Exception
	 */
	@GetMapping(URIConstant.URI_CATEGORY)
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		log.info("getAllCategory start :  CategoryController  :  ");

		List<CategoryDto> allCategory = categoryService.getAllCategory();
		log.info("allCategory  :  CategoryController  :  " + allCategory);

		if (allCategory != null)

			return new ResponseEntity<List<CategoryDto>>(allCategory, HttpStatus.OK);
		else
			throw new NullPointerException(Apiconstants.NULL_USER_RESPONSE);

	}

}
