package com.musinsa.showcase.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.showcase.application.port.dto.OutfitResponse;
import com.musinsa.showcase.application.port.dto.ProductResponse;
import com.musinsa.showcase.application.port.in.FindLowestPricedOutfitByCategoryUsecase;
import com.musinsa.showcase.application.port.out.ReadCategoryPort;
import com.musinsa.showcase.application.port.out.ReadProductPort;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class FindLowestPricedOutfitService implements FindLowestPricedOutfitByCategoryUsecase {

	private final ReadCategoryPort readCategoryPort;

	@Override
	public ProductResponse findLowestPricedProductByCategory(Category category) {
		List<Product> products = category.getProducts();

		if(products == null || products.isEmpty()) {
			throw ApiException.from(ErrorCode.PRODUCT_NOT_FOUND);
		}

		if(products.size() == 1) {
			return products.get(0).toResponse();
		}

		return products
			.stream()
			.min((p1, p2) -> {
				return p1.getPrice().compareTo(p2.getPrice());
			})
			.get()
			.toResponse();
	}


	@Override
	public OutfitResponse findLowestPricedOutfit() {
		List<ProductResponse> products = readCategoryPort
			.loadAllCategories()
			.stream()
			.map(this::findLowestPricedProductByCategory)
			.toList();

		Long totalPrice = products
			.stream()
			.map(ProductResponse::price)
			.reduce(0L, Long::sum);

		return new OutfitResponse(products, totalPrice);
	}
}
