package com.musinsa.showcase.application.port.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musinsa.showcase.application.port.dto.category.ProductOfCategoryResponse;

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
