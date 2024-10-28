package com.musinsa.showcase.adapter.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musinsa.common.dto.DataResponse;
import com.musinsa.showcase.application.port.dto.product.OutfitOfLowestPricedBrandResponse;
import com.musinsa.showcase.application.service.BrandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/brand")
public class BrandController {

	private final BrandService brandService;

	@GetMapping("/outfit/lowest-priced")
	public DataResponse<OutfitOfLowestPricedBrandResponse> findOutfitOfLowestPricedBrand() {
		return DataResponse.from(brandService.findOutfitOfLowestPricedBrand());
	}
}
