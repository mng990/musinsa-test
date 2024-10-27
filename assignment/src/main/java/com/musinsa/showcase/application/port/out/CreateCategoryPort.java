package com.musinsa.showcase.application.port.out;

import java.util.List;

import com.musinsa.showcase.domain.Category;

public interface CreateCategoryPort {
	Long save(Category category);
	List<Long> saveAll(List<Category> categories);
}
