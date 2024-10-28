package com.musinsa.showcase.application.port.in.product;

import com.musinsa.showcase.application.port.dto.product.OutfitOfLowestPricedBrandResponse;

public interface FindLowestPricedOutfitByBrandUsecase {
	public OutfitOfLowestPricedBrandResponse findOutfitOfLowestPricedBrand();
}
