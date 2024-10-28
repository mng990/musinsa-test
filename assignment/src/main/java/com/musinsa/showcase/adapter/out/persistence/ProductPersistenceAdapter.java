package com.musinsa.showcase.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.showcase.application.port.out.CreateProductPort;
import com.musinsa.showcase.application.port.out.ReadProductPort;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

import lombok.RequiredArgsConstructor;

@Component
@Repository
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements CreateProductPort, ReadProductPort {

	private final ProductRepository productRepository;

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

	@Override
	public Long save(Product product) {
		return productRepository
				.save(product)
				.getId();
	}

	@Override
	public List<Long> saveAll(List<Product> products) {
		return products
			.stream()
			.map(this::save)
			.toList();
	}
}
