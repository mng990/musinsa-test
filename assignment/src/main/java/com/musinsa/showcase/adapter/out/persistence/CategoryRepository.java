package com.musinsa.showcase.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musinsa.showcase.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
