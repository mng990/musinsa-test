package com.musinsa.showcase.application.port.in.category;

import java.util.List;

import com.musinsa.showcase.domain.Category;

public interface CreateCategoryUsecase {
	List<Long> saveAll(List<Category> categories);
}
