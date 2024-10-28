package com.musinsa.showcase.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.showcase.application.port.out.product.CreateProductPort;
import com.musinsa.showcase.application.port.out.product.DeleteProductPort;
import com.musinsa.showcase.application.port.out.product.ReadProductPort;
import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

import lombok.RequiredArgsConstructor;

@Component
@Repository
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements
	CreateProductPort,
	ReadProductPort,
	DeleteProductPort {

	private final ProductRepository productRepository;

	@Override
	public Product findProduct(Long productId) {
		return productRepository
			.findById(productId)
			.orElseThrow(() -> ApiException.from(ErrorCode.PRODUCT_NOT_FOUND));
	}

	@Override
	public Long save(Product product) {
		return productRepository
				.save(product)
				.getId();
	}

	@Override
	public Product findMinProductByCategory(Category category) {
		return category
			.getProducts()
			.stream()
			.min((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
			.orElseThrow(()-> ApiException.from(ErrorCode.PRODUCT_IS_EMPTY));
	}

	@Override
	public Product findMaxProductByCategory(Category category) {
		return category
			.getProducts()
			.stream()
			.max((p1, p2)-> p1.getPrice().compareTo(p2.getPrice()))
			.orElseThrow(() -> ApiException.from(ErrorCode.PRODUCT_IS_EMPTY));
	}

	@Override
	public Boolean exists(Product product) {
		return productRepository
			.existsById(product.getId());
	}

	@Override
	public List<Long> saveAll(List<Product> products) {
		return products
			.stream()
			.map(this::save)
			.toList();
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

	@Override
	public void deleteAllByBrand(Brand brand) {
		List<Product> products = productRepository
				.findByBrand(brand);

		if(products.isEmpty()) return;
		productRepository.deleteAll(products);
	}
}
