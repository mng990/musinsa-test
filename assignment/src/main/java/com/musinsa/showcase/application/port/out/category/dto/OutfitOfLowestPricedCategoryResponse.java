package com.musinsa.showcase.application.port.out.category.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musinsa.showcase.application.port.out.product.dto.ProductResponse;

public record OutfitOfLowestPricedCategoryResponse(
	List<ProductResponse> productResponses,
	@JsonProperty("총액")
	String totalPrice
)
{
}
