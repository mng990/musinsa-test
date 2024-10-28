package com.musinsa.showcase.application.port.in;

import com.musinsa.showcase.domain.Category;

public interface FindCategoryUsecase {
	public Category byName(String name);
}
