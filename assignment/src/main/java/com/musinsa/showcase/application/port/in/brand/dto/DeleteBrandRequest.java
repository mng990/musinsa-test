package com.musinsa.showcase.application.port.in.brand.dto;

import jakarta.validation.constraints.NotNull;

public record DeleteBrandRequest(
	@NotNull(message = "brandId is null")
	Long brandId
) {
}
