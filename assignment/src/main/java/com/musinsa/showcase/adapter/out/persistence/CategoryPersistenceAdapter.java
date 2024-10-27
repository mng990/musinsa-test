package com.musinsa.showcase.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.musinsa.showcase.application.port.out.LoadCategoryPort;
import com.musinsa.showcase.domain.Category;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements LoadCategoryPort {

	private final CategoryRepository categoryRepository;

	@Override
	public Category loadCategory(Long categoryId) {
		return categoryRepository.findById(categoryId).orElse(null);
	}

	@Override
	public List<Category> loadAllCategories() {
		return categoryRepository.findAll();
	}
}
