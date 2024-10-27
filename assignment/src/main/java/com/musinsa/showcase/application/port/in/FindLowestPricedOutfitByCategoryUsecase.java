package com.musinsa.showcase.application.port.in;

import java.util.List;

import com.musinsa.showcase.application.port.ProductResponse;
import com.musinsa.showcase.domain.Category;

public interface FindLowestPricedOutfitByCategoryUsecase {
	public ProductResponse findLowestPricedProductByCategory(Category category);
	public List<ProductResponse> findLowestPricedOutfit();
}
