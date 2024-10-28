package com.musinsa.showcase.application.port.out.brand.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record OutfitOfLowestPricedBrandResponse(
	@JsonProperty("최저가")
	@Valid
	OutfitOfBrandResponse outfitOfLowestPricedBrandResponse
)
{
}
