package com.musinsa.showcase.application.port.out.product;

import java.util.List;

import com.musinsa.showcase.domain.Product;

public interface CreateProductPort {
	Product save(Product product);
	List<Product> saveAll(List<Product> products);
}
