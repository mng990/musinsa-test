package com.musinsa.showcase.application.port.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musinsa.showcase.application.port.dto.brand.OutfitOfBrandResponse;
import com.musinsa.showcase.application.port.dto.brand.ProductOfBrandResponse;

public record OutfitOfLowestPricedBrandResponse(
	@JsonProperty("최저가")
	OutfitOfBrandResponse outfitOfLowestPricedBrandResponse
)
{
}
