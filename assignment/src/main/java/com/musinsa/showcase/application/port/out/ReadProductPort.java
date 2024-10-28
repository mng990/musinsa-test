package com.musinsa.showcase.application.port.out;

import java.util.List;

import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

public interface ReadProductPort {
	Product loadProduct(Long productId);
	List<Product> loadProductsByCategory(Category category);
	Product loadMinProductByCategory(Category category);
	Product loadMaxProductByCategory(Category category);
}
