package com.musinsa.showcase.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musinsa.showcase.application.port.dto.MinMaxProductByCategoryResponse;
import com.musinsa.showcase.application.port.in.FindCategoryUsecase;
import com.musinsa.showcase.application.port.in.FindLowestAndHighestProductsByCategoryUsecase;
import com.musinsa.showcase.application.port.out.ReadCategoryPort;
import com.musinsa.showcase.application.port.out.ReadProductPort;
import com.musinsa.showcase.domain.Category;

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
		return new MinMaxProductByCategoryResponse(
			category.getName(),
			readProductPort
				.loadMinProductByCategory(category)
				.toProductOfCategoryResponse(),
			readProductPort
				.loadMaxProductByCategory(category)
				.toProductOfCategoryResponse()
		);
	}
}
