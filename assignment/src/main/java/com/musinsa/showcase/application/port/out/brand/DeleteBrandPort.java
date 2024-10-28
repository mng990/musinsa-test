package com.musinsa.showcase.application.port.out.brand;

import java.util.List;

import com.musinsa.showcase.domain.Brand;

public interface DeleteBrandPort {
	public void delete(Brand brand);
	public void deleteAll(List<Brand> brands);
}
