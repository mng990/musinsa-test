package com.musinsa.showcase.application.port.in.product;

import java.util.List;

import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

public interface FindProductUsecase {
	public List<Product> byCategory(Category category);
}
