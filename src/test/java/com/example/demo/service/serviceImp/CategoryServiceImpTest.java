package com.example.demo.service.serviceImp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Dao.CategoryDao;
import com.example.demo.dto.CategoryDto;

@SpringBootTest(classes = { CategoryServiceImpTest.class })
public class CategoryServiceImpTest {

	@InjectMocks
	private CategoryServiceImp categoryServiceImp;
	@Mock
	private CategoryDao categoryDao;

	/**
	 * @author yogeshwar chate
	 * @apiNote this is test case create Category method
	 * 
	 */

	@Test
	public void createCategoryTest() {

		CategoryDto dto = new CategoryDto(1, " Dell laptop", "this is dell laptop related post plse check it");

		when(categoryDao.saveCategory(dto)).thenReturn(dto);
		CategoryDto createCategory = categoryServiceImp.createCategory(dto);

		int categoryId = createCategory.getCategoryId();

		assertEquals(1, categoryId);

	}

	@Test
	public void updateCategoryTest() {


		CategoryDto newObjectdto = new CategoryDto(1, " Dell laptop", "this is dell laptop related post plse check it");

		CategoryDto OldObjectdto = new CategoryDto(1, " lenovo laptop",
				"this is lenovo laptop related post plse check it");
		int id = 1;

		when(categoryDao.getCategory(1)).thenReturn(OldObjectdto);
		when(categoryDao.updateCategory(OldObjectdto)).thenReturn(newObjectdto);
		CategoryDto updateCategory = categoryServiceImp.updateCategory(newObjectdto, id);
		System.out.println(updateCategory);

		assertEquals(1, updateCategory.getCategoryId());

	}

}
