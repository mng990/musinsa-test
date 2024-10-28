package com.musinsa.showcase.application.port.in.product;

import com.musinsa.showcase.application.port.in.product.dto.DeleteProductRequest;
import com.musinsa.showcase.domain.Product;

public interface DeleteProductUsecase {
	public void delete(DeleteProductRequest deleteProductRequest);
}
