package com.musinsa.showcase.application.port.in;

import java.util.List;

import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

public interface FindProductsByCategory {
	public List<Product> findProductsByCategory(Category category);
}
