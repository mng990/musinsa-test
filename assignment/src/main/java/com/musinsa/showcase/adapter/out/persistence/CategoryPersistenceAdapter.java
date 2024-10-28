package com.musinsa.showcase.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.showcase.application.port.out.category.CreateCategoryPort;
import com.musinsa.showcase.application.port.out.category.ReadCategoryPort;
import com.musinsa.showcase.domain.Category;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CreateCategoryPort, ReadCategoryPort {

	private final CategoryRepository categoryRepository;

	@Override
	public Optional<Category> findByName(String categoryName) {
		if(categoryName == null || categoryName.isEmpty()){
			throw ApiException.from(ErrorCode.CATEGORY_NAME_IS_EMPTY);
		}

		return categoryRepository
			.findByName(categoryName);
	}

	@Override
	public List<Category> findAllCategories() {
		return categoryRepository
			.findAll();
	}

	@Override
	public Optional<Category> findById(Long categoryId) {
		return categoryRepository
			.findById(categoryId);
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
			.map((c) -> categoryRepository.save(c).getId())
			.toList();
	}
}
