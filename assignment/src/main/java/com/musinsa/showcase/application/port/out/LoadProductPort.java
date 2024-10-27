package com.musinsa.showcase.application.port.out;

import java.time.LocalDateTime;
import java.util.List;

import com.musinsa.showcase.application.port.ProductResponse;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

public interface LoadProductPort {
	Product loadProduct(Long productId);
	List<Product> loadProductsByCategory(Category category);

}
