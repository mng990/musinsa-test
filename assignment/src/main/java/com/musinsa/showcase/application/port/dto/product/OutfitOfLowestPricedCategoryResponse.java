package com.musinsa.showcase.application.port.dto.product;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OutfitOfLowestPricedCategoryResponse(
	List<ProductResponse> productResponses,
	@JsonProperty("총액")
	String totalPrice
)
{
}
