package com.musinsa.showcase.application.port.in;

import com.musinsa.showcase.application.port.dto.MinMaxProductByCategoryResponse;
import com.musinsa.showcase.domain.Category;

public interface FindLowestAndHighestProductsByCategoryUsecase {
	public MinMaxProductByCategoryResponse findLowestAndHighestProductByCategory(Category category);
}
