package com.musinsa.showcase.adapter.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musinsa.common.dto.DataResponse;
import com.musinsa.showcase.application.port.dto.OutfitOfLowestPricedCategoryResponse;
import com.musinsa.showcase.application.port.in.product.FindLowestPricedOutfitByCategoryUsecase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

	private final FindLowestPricedOutfitByCategoryUsecase findLowestPricedOutfitByCategoryUsecase;

	@GetMapping("/outfit/lowest-priced")
	public DataResponse<OutfitOfLowestPricedCategoryResponse> findLowestPricedOutfit() {
		OutfitOfLowestPricedCategoryResponse outfitOfLowestPricedCategoryResponse = findLowestPricedOutfitByCategoryUsecase
			.findLowestPricedOutfit();

		return DataResponse.from(outfitOfLowestPricedCategoryResponse);
	}
}
