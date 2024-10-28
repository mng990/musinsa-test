package com.musinsa.common.mapper;

import com.musinsa.showcase.application.port.dto.ProductOfBrandResponse;
import com.musinsa.showcase.application.port.dto.ProductOfCategoryResponse;
import com.musinsa.showcase.application.port.dto.ProductResponse;
import com.musinsa.showcase.domain.Product;

public class ProductMapper {

	public static ProductResponse toProductResponse(Product product) {
		return new ProductResponse(
			product.getCategory().getName(),
			product.getBrand().getName(),
			String.format("%,d", product.getPrice())
		);
	}

	public static ProductOfCategoryResponse toProductOfCategoryResponse(Product product) {
		return new ProductOfCategoryResponse(
			product.getBrand().getName(),
			String.format("%,d", product.getPrice())
		);
	}

	public static ProductOfBrandResponse toProductOfBrandResponse(Product product){
		return new ProductOfBrandResponse(
			product.getCategory().getName(),
			String.format("%,d", product.getPrice())
		);
	}
}
