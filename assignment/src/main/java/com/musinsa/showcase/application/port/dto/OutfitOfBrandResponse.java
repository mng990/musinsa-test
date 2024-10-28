package com.musinsa.showcase.application.port.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OutfitOfBrandResponse(
	@JsonProperty("브랜드")
	String brand,
	@JsonProperty("카테고리")
	List<ProductOfBrandResponse> products,
	@JsonProperty("총액")
	String totalPrice
) {
}
