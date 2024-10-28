package com.musinsa.showcase.application.port.out.category;

import java.util.List;
import java.util.Optional;

import com.musinsa.showcase.domain.Category;

public interface CreateCategoryPort {
	Category save(Category category);
	List<Category> saveAll(List<Category> categories);
}
