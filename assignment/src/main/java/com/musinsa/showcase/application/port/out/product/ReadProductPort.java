package com.musinsa.showcase.application.port.out.product;

import java.util.List;

import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

public interface ReadProductPort {
	Product findProduct(Long productId);
	List<Product> findProductsByCategory(Category category);
	Product findMinProductByCategory(Category category);
	Product findMaxProductByCategory(Category category);
	Boolean exists(Product product);
}
