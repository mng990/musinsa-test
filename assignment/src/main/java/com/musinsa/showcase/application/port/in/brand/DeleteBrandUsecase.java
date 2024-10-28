package com.musinsa.showcase.application.port.in.brand;

import com.musinsa.showcase.application.port.in.brand.dto.DeleteBrandRequest;

public interface DeleteBrandUsecase {
	public void delete(DeleteBrandRequest brand);
}
