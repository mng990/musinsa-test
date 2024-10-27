package com.musinsa.showcase.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.musinsa.showcase.application.port.out.CreateBrandPort;
import com.musinsa.showcase.application.port.out.ReadBrandPort;
import com.musinsa.showcase.domain.Brand;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BrandPersistenceAdapter implements CreateBrandPort, ReadBrandPort {
	private final BrandRepository brandRepository;

	@Override
	public Long save(Brand brand) {
		return brandRepository
				.save(brand)
				.getId();
	}

	@Override
	public List<Long> saveAll(List<Brand> brands) {
		return brands
				.stream()
				.map(this::save)
				.toList();
	}
}
