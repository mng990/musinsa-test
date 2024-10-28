package com.musinsa.showcase.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musinsa.common.mapper.ProductMapper;
import com.musinsa.showcase.application.port.dto.MinMaxProductByCategoryResponse;
import com.musinsa.showcase.application.port.in.category.FindCategoryUsecase;
import com.musinsa.showcase.application.port.in.product.FindLowestAndHighestProductsByCategoryUsecase;
import com.musinsa.showcase.application.port.out.ReadCategoryPort;
import com.musinsa.showcase.application.port.out.ReadProductPort;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService implements
	FindCategoryUsecase,
	FindLowestAndHighestProductsByCategoryUsecase {

	private final ReadCategoryPort readCategoryPort;
	private final ReadProductPort readProductPort;

	@Override
	public Category byName(String name) {
		return readCategoryPort.loadCategoryBy(name);
	}

	@Override
	public MinMaxProductByCategoryResponse findLowestAndHighestProductByCategory(Category category) {
		Product minProduct = readProductPort.loadMinProductByCategory(category),
				maxProduct = readProductPort.loadMaxProductByCategory(category);

		return new MinMaxProductByCategoryResponse(
			category.getName(),
			ProductMapper.toProductOfCategoryResponse(minProduct),
			ProductMapper.toProductOfCategoryResponse(maxProduct)
		);
	}
}
