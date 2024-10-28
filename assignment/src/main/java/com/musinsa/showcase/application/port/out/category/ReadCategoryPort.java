package com.musinsa.showcase.application.port.out.category;

import java.util.List;
import java.util.Optional;

import com.musinsa.showcase.domain.Category;

public interface ReadCategoryPort {
	Optional<Category> findByName(String categoryName);
	Optional<Category> findById(Long categoryId);
	List<Category> findAllCategories();
}
