package com.musinsa.showcase.application.port.in.product;

import com.musinsa.showcase.application.port.out.product.dto.MinMaxProductByCategoryResponse;
import com.musinsa.showcase.domain.Category;

public interface FindLowestAndHighestProductsByCategoryUsecase {
	public MinMaxProductByCategoryResponse findLowestAndHighestProductByCategory(Category category);
}
