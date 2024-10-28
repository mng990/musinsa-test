package com.musinsa.showcase.application.port.out;

import java.util.List;

import com.musinsa.showcase.domain.Category;

public interface ReadCategoryPort {
	Category loadCategory(Long categoryId);
	List<Category> loadAllCategories();
}
