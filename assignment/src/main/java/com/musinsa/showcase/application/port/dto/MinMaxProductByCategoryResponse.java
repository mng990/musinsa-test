package com.musinsa.showcase.application.port.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MinMaxProductByCategoryResponse(
	@JsonProperty("카테고리")
	String category,
	@JsonProperty("최저가")
	ProductOfCategoryResponse minProduct,
	@JsonProperty("최고가")
	ProductOfCategoryResponse maxProduct
)
{
}
