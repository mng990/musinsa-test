package com.musinsa.showcase.application.port.in.brand.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateBrandRequest(
	@NotNull(message = "brandId is null")
	Long brandId,
	@NotNull(message = "name is null")
	String name
) {
}
