package com.musinsa.showcase.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.common.mapper.ProductMapper;
import com.musinsa.showcase.application.port.out.category.dto.OutfitOfLowestPricedCategoryResponse;
import com.musinsa.showcase.application.port.out.product.dto.ProductResponse;
import com.musinsa.showcase.application.port.in.product.FindLowestPricedOutfitByCategoryUsecase;
import com.musinsa.showcase.application.port.out.category.ReadCategoryPort;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService implements
	FindLowestPricedOutfitByCategoryUsecase {

	private final ReadCategoryPort readCategoryPort;

	@Override
	public ProductResponse findLowestPricedProductByCategory(Category category) {
		List<Product> products = category.getProducts();

		Product product = products
			.stream()
			.min((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
			.orElseThrow(() -> ApiException.from(ErrorCode.PRODUCT_NOT_FOUND));

		return ProductMapper.toProductResponse(product);
	}

	@Override
	public OutfitOfLowestPricedCategoryResponse findLowestPricedOutfit() {
		List<ProductResponse> products = readCategoryPort
			.findAllCategories()
			.stream()
			.map(this::findLowestPricedProductByCategory)
			.toList();

		Long totalPrice = products
			.stream()
			.map((p) -> Long.parseLong(p.price().replace(",","")))
			.reduce(0L, Long::sum);

		return new OutfitOfLowestPricedCategoryResponse(products, String.format("%,d",totalPrice));
	}
}
