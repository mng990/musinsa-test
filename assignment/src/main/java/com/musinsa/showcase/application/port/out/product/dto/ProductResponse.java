package com.musinsa.showcase.application.port.out.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponse(
	@JsonProperty("카테고리")
	String category,
	@JsonProperty("브랜드")
	String brand,
	@JsonProperty("가격")
	String price
)
{
}
