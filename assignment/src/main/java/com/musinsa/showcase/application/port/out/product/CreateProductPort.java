package com.musinsa.showcase.application.port.out.product;

import java.util.List;

import com.musinsa.showcase.domain.Product;

public interface CreateProductPort {
	Long save(Product product);
	List<Long> saveAll(List<Product> products);
}
