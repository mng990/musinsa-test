package com.musinsa.showcase.adapter.out.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
	@Query("SELECT p FROM Product p WHERE p.brand = ?1 AND p.category = ?2 ORDER BY p.price ASC")
	public List<Product> findProductsByBrandAndCategory(Brand brand, Category category);
}
