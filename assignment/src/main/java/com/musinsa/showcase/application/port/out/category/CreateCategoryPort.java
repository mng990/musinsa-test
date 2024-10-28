package com.musinsa.showcase.application.port.out.category;

import java.util.List;
import java.util.Optional;

import com.musinsa.showcase.domain.Category;

public interface CreateCategoryPort {
	Long save(Category category);
	List<Long> saveAll(List<Category> categories);
}
