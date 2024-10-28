package com.musinsa.showcase.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.showcase.application.port.out.brand.CreateBrandPort;
import com.musinsa.showcase.application.port.out.brand.DeleteBrandPort;
import com.musinsa.showcase.application.port.out.brand.ReadBrandPort;
import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BrandPersistenceAdapter implements
	CreateBrandPort,
	ReadBrandPort,
	DeleteBrandPort {

	private final BrandRepository brandRepository;
	private final CategoryRepository categoryRepository;

	@Override
	public Brand save(Brand brand) {
		return brandRepository
			.save(brand);
	}

	@Override
	public List<Brand> saveAll(List<Brand> brands) {
		return brands
				.stream()
				.map(this::save)
				.toList();
	}

	@Override
	public Brand findLowestPricedBrand() {
		List<Brand> brands = brandRepository.findAll();

		if(brands.isEmpty()){
			throw ApiException.from(ErrorCode.BRAND_IS_EMPTY);
		}

		if(brands.size() == 1){
			return brands.get(0);
		}

		return brands
			.stream()
			.min((b1, b2) -> totalPriceByBrand(b1).compareTo(totalPriceByBrand(b2)))
			.get();
	}

	@Override
	public List<Brand> findAllBrands() {
		return brandRepository.findAll();
	}

	@Override
	public Product findLowestPricedProductByBrandAndCategory(Brand brand, Category category) {
		return findAllProductsByBrandAndCategory(brand, category).get(0);
	}

	@Override
	public List<Product> findLowestPricedProductsByBrand(Brand brand) {
	    List<Category> categories = categoryRepository.findAll();

		if(categories.isEmpty()){
			throw ApiException.from(ErrorCode.CATEGORY_IS_EMPTY);
		}

		return categories
				.stream()
				.map((category) -> findLowestPricedProductByBrandAndCategory(brand, category))
				.toList();
	}

	@Override
	public List<Product> findAllProductsByBrandAndCategory(Brand brand, Category category) {
		return brand
			.getProducts()
			.stream()
			.filter(product -> product.getCategory().equals(category))
			.toList();
	}

	@Override
	public Boolean exists(Brand brand) {
		return brandRepository.existsById(brand.getId());
	}

	@Override
	public Optional<Brand> findById(Long id) {
		return brandRepository.findById(id);
	}

	protected Long totalPriceByBrand(Brand brand) {
		return findLowestPricedProductsByBrand(brand)
			.stream()
			.map(Product::getPrice)
			.reduce(0L, Long::sum);
	}

	@Override
	public void delete(Brand brand) {
		brandRepository.delete(brand);
	}
}
