package com.musinsa.showcase.application.port.in.product;

import java.util.List;

import com.musinsa.showcase.application.port.in.product.dto.CreateProductRequest;

public interface CreateProductUsecase {
	public Long save(CreateProductRequest createProductRequest);
	public List<Long> saveAll(List<CreateProductRequest> createProductRequests);
}
