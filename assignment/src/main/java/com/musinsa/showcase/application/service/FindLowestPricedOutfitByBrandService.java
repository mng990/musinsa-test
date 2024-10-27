package com.musinsa.showcase.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.showcase.adapter.out.persistence.BrandRepository;
import com.musinsa.showcase.adapter.out.persistence.CategoryRepository;
import com.musinsa.showcase.application.port.dto.OutfitResponse;
import com.musinsa.showcase.application.port.dto.ProductResponse;
import com.musinsa.showcase.application.port.in.FindLowestPricedOutfitByBrandUsecase;
import com.musinsa.showcase.application.port.out.ReadBrandPort;
import com.musinsa.showcase.application.port.out.ReadCategoryPort;
import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FindLowestPricedOutfitByBrandService implements
	FindLowestPricedOutfitByBrandUsecase {

	private final ReadBrandPort readBrandPort;
	private final ReadCategoryPort readCategoryPort;

	@Override
	public Brand findLowestPricedBrand() {

		return null;
	}

	@Override
	public ProductResponse findLowestPricedProductByBrandAndCategory(Brand brand, Category category) {
		List<Product> products = readBrandPort.loadAllProductsByBrandAndCategory(brand, category);

		if(products == null || products.isEmpty()) {
			throw ApiException.from(ErrorCode.PRODUCT_NOT_FOUND);
		}

		return products.get(0).toResponse();
	}

	@Override
	public OutfitResponse findLowestPricedOutfitByBrand(Brand brand) {
		List<Category> categories = readCategoryPort.loadAllCategories();
		List<Brand> brands = readBrandPort.loadAllBrands();

		if(categories == null || categories.isEmpty()){
			throw ApiException.from(ErrorCode.CATEGORY_NOT_FOUND);
		}

		List<ProductResponse> outfit =

		return null;
	}

	@Override
	public OutfitResponse findLowestPricedOutfit() {
		return null;
	}
}
