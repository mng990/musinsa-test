package com.musinsa.showcase.application.port.in;

import com.musinsa.showcase.application.port.dto.OutfitResponse;
import com.musinsa.showcase.application.port.dto.ProductResponse;
import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

public interface FindLowestPricedOutfitByBrandUsecase {
	public Brand findLowestPricedBrand();
	public ProductResponse findLowestPricedProductByBrandAndCategory(Brand brand, Category category);
	public OutfitResponse findLowestPricedOutfitByBrand(Brand brand);
	public OutfitResponse findLowestPricedOutfit();
}
