package com.musinsa.showcase.application.port.out.product;

import java.util.List;

import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Product;

public interface DeleteProductPort {
	public void delete(Product product);
	public void deleteAll(List<Product> productList);
	public void deleteAllByBrand(Brand brand);
}
