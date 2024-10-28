package com.musinsa.common.mapper;

import com.musinsa.showcase.application.port.dto.brand.ProductOfBrandResponse;
import com.musinsa.showcase.application.port.dto.category.ProductOfCategoryResponse;
import com.musinsa.showcase.application.port.dto.product.ProductResponse;
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
