package com.musinsa.showcase.application.port.in.brand;

import com.musinsa.showcase.application.port.in.brand.dto.CreateBrandRequest;

public interface CreateBrandUsecase {
	public Long save(CreateBrandRequest brad);
}
