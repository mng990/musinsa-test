package com.musinsa.showcase.application.port.in.product;

import com.musinsa.showcase.application.port.out.brand.dto.OutfitOfLowestPricedBrandResponse;

public interface FindLowestPricedOutfitByBrandUsecase {
	public OutfitOfLowestPricedBrandResponse findOutfitOfLowestPricedBrand();
}
