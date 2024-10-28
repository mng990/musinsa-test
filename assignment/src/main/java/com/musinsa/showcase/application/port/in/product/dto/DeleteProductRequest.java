package com.musinsa.showcase.application.port.in.product.dto;

import jakarta.validation.constraints.NotNull;

public record DeleteProductRequest(
	@NotNull(message = "productId is null")
	Long productId
) {
}
