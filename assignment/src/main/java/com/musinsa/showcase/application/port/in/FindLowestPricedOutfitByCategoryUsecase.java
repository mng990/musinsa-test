package com.musinsa.showcase.application.port.in;

import com.musinsa.showcase.application.port.dto.OutfitResponse;
import com.musinsa.showcase.application.port.dto.ProductResponse;
import com.musinsa.showcase.domain.Category;

public interface FindLowestPricedOutfitByCategoryUsecase {
	public ProductResponse findLowestPricedProductByCategory(Category category);
	public OutfitResponse  findLowestPricedOutfit();
}
