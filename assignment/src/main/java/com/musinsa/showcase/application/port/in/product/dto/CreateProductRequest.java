package com.musinsa.showcase.application.port.in.product.dto;

import jakarta.validation.constraints.NotNull;

public record CreateProductRequest(
	@NotNull(message = "name is null")
	Long brandId,
	@NotNull(message = "categoryId is null")
	Long categoryId,
	@NotNull(message = "price is null")
	Long price
) {
}
