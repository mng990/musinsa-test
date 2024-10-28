package com.musinsa.showcase.application.port.out.brand;

import java.util.List;

import com.musinsa.showcase.domain.Brand;

public interface CreateBrandPort {
	Brand save(Brand brand);
	List<Brand> saveAll(List<Brand> brands);
}
