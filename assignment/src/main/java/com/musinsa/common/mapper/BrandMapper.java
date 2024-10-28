package com.musinsa.common.mapper;

import com.musinsa.showcase.application.port.in.brand.dto.CreateBrandRequest;
import com.musinsa.showcase.domain.Brand;

public class BrandMapper {
	public static Brand toBrand(CreateBrandRequest brandRequest) {
		return Brand
			.builder()
			.name(brandRequest.name())
			.build();
	}
}
