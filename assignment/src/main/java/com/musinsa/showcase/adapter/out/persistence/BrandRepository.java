package com.musinsa.showcase.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musinsa.showcase.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
