package com.musinsa.showcase.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musinsa.showcase.application.port.ProductResponse;
import com.musinsa.showcase.application.port.in.FindLowestPricedOutfitByCategoryUsecase;
import com.musinsa.showcase.application.port.out.LoadCategoryPort;
import com.musinsa.showcase.application.port.out.LoadProductPort;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class FindLowestPricedOutfitService implements FindLowestPricedOutfitByCategoryUsecase {

	private final LoadProductPort loadProductPort;
	private final LoadCategoryPort loadCategoryPort;

	@Override
	public ProductResponse findLowestPricedProductByCategory(Category category) {
		List<Product> products = loadProductPort.loadProductsByCategory(category);
		return products
			.stream()
			.min((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
			.get()
			.toResponse();
	}


	@Override
	public List<ProductResponse> findLowestPricedOutfit() {
		List<Category> categories = loadCategoryPort.loadAllCategories();
		return categories
			.stream()
			.map(this::findLowestPricedProductByCategory)
			.toList();
	}
}
