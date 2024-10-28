package com.musinsa.showcase.application.port.out;

import java.util.List;

import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

public interface ReadCategoryPort {
	Category loadCategoryBy(String categoryName);
	Category loadCategoryBy(Long categoryId);
	List<Category> loadAllCategories();
}
