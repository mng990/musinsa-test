package com.musinsa.showcase.application.port.in.product;

import com.musinsa.showcase.application.port.in.product.dto.CreateProductRequest;

public interface CreateProductUsecase {
	public Long save(CreateProductRequest createProductRequest);
}
