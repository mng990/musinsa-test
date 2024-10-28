package com.musinsa.showcase.adapter.out.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategory(Category category);
	List<Product> findMinMaxProductsByCategory(Category category);
}
