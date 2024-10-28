package com.musinsa.showcase.application.port.in.product.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateProductRequest(
	@NotNull(message = "productId is null")
	Long productId,
	@NotNull(message = "brandId is null")
	Long brandId,
	@NotNull(message = "categoryId is null")
	Long categoryId,
	@NotNull(message = "price is null")
	Long price
) {
}
