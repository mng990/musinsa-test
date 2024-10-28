package com.musinsa.showcase.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.showcase.application.port.out.CreateCategoryPort;
import com.musinsa.showcase.application.port.out.ReadCategoryPort;
import com.musinsa.showcase.domain.Category;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CreateCategoryPort, ReadCategoryPort {

	private final CategoryRepository categoryRepository;

	@Override
	public Category loadCategoryBy(String categoryName) {
		if(categoryName == null || categoryName.isEmpty()){
			throw ApiException.from(ErrorCode.CATEGORY_NAME_IS_EMPTY);
		}

		return categoryRepository
			.findCategoryByName(categoryName)
			.orElseThrow(() -> ApiException.from(ErrorCode.CATEGORY_NOT_FOUND));
	}

	@Override
	public Category loadCategoryBy(Long categoryId) {
		return categoryRepository
			.findById(categoryId)
			.orElseThrow(() -> ApiException.from(ErrorCode.CATEGORY_IS_EMPTY));
	}

	@Override
	public List<Category> loadAllCategories() {
		return categoryRepository
			.findAll();
	}

	@Override
	public Long save(Category category) {
		return categoryRepository
			.save(category)
			.getId();
	}

	@Override
	public List<Long> saveAll(List<Category> categories) {
		return categories
			.stream()
			.map(this::save)
			.toList();
	}
}
