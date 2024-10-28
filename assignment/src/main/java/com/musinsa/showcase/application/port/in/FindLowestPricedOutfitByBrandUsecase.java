package com.musinsa.showcase.application.port.in;

import com.musinsa.showcase.application.port.dto.OutfitOfLowestPricedBrandResponse;

public interface FindLowestPricedOutfitByBrandUsecase {
	public OutfitOfLowestPricedBrandResponse findOutfitOfLowestPricedBrand();
}
