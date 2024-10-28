package com.musinsa.showcase.application.port.out.brand;

import java.util.List;
import java.util.Optional;

import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

public interface ReadBrandPort {
	Brand findLowestPricedBrand();
	Product findLowestPricedProductByBrandAndCategory(Brand brand, Category category);
	List<Product> findLowestPricedProductsByBrand(Brand brand);
	List<Product> findAllProductsByBrandAndCategory(Brand brand, Category category);
	Optional<Brand> findById(Long id);
}
