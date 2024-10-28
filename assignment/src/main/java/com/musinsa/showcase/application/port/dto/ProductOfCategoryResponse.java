package com.musinsa.showcase.application.port.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductOfCategoryResponse(
	@JsonProperty("브랜드")
	String brand,
	@JsonProperty("가격")
	String price
)
{
}