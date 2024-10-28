package com.musinsa.showcase.application.port.out;

import java.util.List;

import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

public interface ReadBrandPort {
	Brand loadLowestPricedBrand();
	List<Brand> loadAllBrands();
	Product loadLowestPricedProductByBrandAndCategory(Brand brand, Category category);
	List<Product> loadLowestPricedProductsByBrand(Brand brand);
	List<Product> loadAllProductsByBrandAndCategory(Brand brand, Category category);
}
