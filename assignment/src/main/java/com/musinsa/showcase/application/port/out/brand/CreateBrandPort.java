package com.musinsa.showcase.application.port.out.brand;

import java.util.List;

import com.musinsa.showcase.domain.Brand;

public interface CreateBrandPort {
	Long save(Brand brand);
	List<Long> saveAll(List<Brand> brands);
}
