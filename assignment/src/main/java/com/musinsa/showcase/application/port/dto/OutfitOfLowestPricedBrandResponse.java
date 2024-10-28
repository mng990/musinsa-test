package com.musinsa.showcase.application.port.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OutfitOfLowestPricedBrandResponse(
	@JsonProperty("최저가")
	OutfitOfBrandResponse outfitOfLowestPricedBrandResponse
)
{
}
