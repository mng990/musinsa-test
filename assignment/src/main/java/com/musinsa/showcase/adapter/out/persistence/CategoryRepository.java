package com.musinsa.showcase.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findCategoryByName(String name);
}
