package com.musinsa.showcase.adapter.out.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.showcase.application.port.ProductResponse;
import com.musinsa.showcase.application.port.out.LoadCategoryPort;
import com.musinsa.showcase.application.port.out.LoadProductPort;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements LoadProductPort {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;


	@Override
	public Product loadProduct(Long productId) {
		return productRepository
			.findById(productId)
			.orElseThrow(() -> ApiException.from(ErrorCode.PRODUCT_NOT_FOUND));
	}

	@Override
	public List<Product> loadProductsByCategory(Category category) {
		return productRepository.findByCategory(category);
	}
}
