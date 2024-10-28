package com.musinsa.showcase.application.port.in.brand;

import java.util.List;

import com.musinsa.showcase.application.port.in.brand.dto.CreateBrandRequest;

public interface CreateBrandUsecase {
	public Long save(CreateBrandRequest brad);
	public List<Long> saveAll(List<CreateBrandRequest> brands);
}
