package com.musinsa.showcase.application.port.out.brand;

import com.musinsa.showcase.domain.Brand;

public interface ReadBrandUsecase {
	Brand findById(Long id);
}
