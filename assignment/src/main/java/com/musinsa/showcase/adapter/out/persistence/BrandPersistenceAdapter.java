package com.musinsa.showcase.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.showcase.application.port.out.CreateBrandPort;
import com.musinsa.showcase.application.port.out.ReadBrandPort;
import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BrandPersistenceAdapter implements CreateBrandPort, ReadBrandPort {

	private final BrandRepository brandRepository;
	private final CategoryRepository categoryRepository;

	@Override
	public Long save(Brand brand) {
		return brandRepository
			.save(brand)
			.getId();
	}

	@Override
	public List<Long> saveAll(List<Brand> brands) {
		return brands
				.stream()
				.map(this::save)
				.toList();
	}

	@Override
	public Brand loadLowestPricedBrand() {
		List<Brand> brands = brandRepository.findAll();

		if(brands.isEmpty()){
			throw ApiException.from(ErrorCode.BRAND_IS_EMPTY);
		}

		if(brands.size() == 1){
			return brands.get(0);
		}

		return brands
			.stream()
			.max((b1, b2) -> totalPriceByBrand(b1).compareTo(totalPriceByBrand(b2)))
			.get();
	}

	@Override
	public List<Brand> loadAllBrands() {
		return brandRepository.findAll();
	}

	@Override
	public Product loadLowestPricedProductByBrandAndCategory(Brand brand, Category category) {
		return loadAllProductsByBrandAndCategory(brand, category).get(0);
	}

	@Override
	public List<Product> loadLowestPricedProductsByBrand(Brand brand) {
	    List<Category> categories = categoryRepository.findAll();

		if(categories.isEmpty()){
			throw ApiException.from(ErrorCode.CATEGORY_IS_EMPTY);
		}

		return categories
				.stream()
				.map((category) -> loadLowestPricedProductByBrandAndCategory(brand, category))
				.toList();
	}

	@Override
	public List<Product> loadAllProductsByBrandAndCategory(Brand brand, Category category) {
		return brandRepository.findProductsByBrandAndCategory(brand, category);
	}

	protected Long totalPriceByBrand(Brand brand) {
		return loadLowestPricedProductsByBrand(brand)
			.stream()
			.map(Product::getPrice)
			.reduce(0L, Long::sum);
	}
}
