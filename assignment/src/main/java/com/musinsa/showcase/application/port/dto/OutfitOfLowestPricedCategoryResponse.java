package com.musinsa.showcase.application.port.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OutfitOfLowestPricedCategoryResponse(
	List<ProductResponse> productResponses,
	@JsonProperty("총액")
	String totalPrice
)
{
	public Long totalPriceByLong() {
		return Long.parseLong(totalPrice.replaceAll(",", ""));
	}
}
