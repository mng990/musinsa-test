package com.musinsa.showcase.application.port.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductOfBrandResponse(
	@JsonProperty("카테고리")
	String category,
	@JsonProperty("가격")
	String price
)
{
	public Long priceByLong() {
		return Long.parseLong(price.replaceAll(",", ""));
	}
}
