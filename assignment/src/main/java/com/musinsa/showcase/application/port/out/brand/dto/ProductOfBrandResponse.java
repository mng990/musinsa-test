package com.musinsa.showcase.application.port.out.brand.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public record ProductOfBrandResponse(
	@JsonProperty("카테고리")
	String category,
	@JsonProperty("가격")
	String price
)
{
}
