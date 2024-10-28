package com.musinsa.showcase.adapter.in;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musinsa.common.dto.DataResponse;
import com.musinsa.showcase.application.port.in.brand.dto.CreateBrandRequest;
import com.musinsa.showcase.application.port.in.brand.dto.DeleteBrandRequest;
import com.musinsa.showcase.application.port.in.brand.dto.UpdateBrandRequest;
import com.musinsa.showcase.application.port.out.brand.dto.OutfitOfLowestPricedBrandResponse;
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

	@PostMapping
	public DataResponse<Void> createBrand(@RequestBody CreateBrandRequest createBrandRequest) {
		brandService.save(createBrandRequest);
		return DataResponse.created();
	}

	@PutMapping
	public DataResponse<Void> updateBrand(@RequestBody UpdateBrandRequest updateBrandRequest) {
		brandService.update(updateBrandRequest);
		return DataResponse.ok();
	}

	@DeleteMapping
	public DataResponse<Void> deleateBrand(@RequestBody DeleteBrandRequest deleteBrandRequest) {
		brandService.delete(deleteBrandRequest);
		return DataResponse.noContent();
	}
}
