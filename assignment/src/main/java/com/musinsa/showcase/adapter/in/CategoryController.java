package com.musinsa.showcase.adapter.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musinsa.common.dto.DataResponse;
import com.musinsa.showcase.application.port.dto.OutfitResponse;
import com.musinsa.showcase.application.port.in.FindLowestPricedOutfitByCategoryUsecase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryController {

	private final FindLowestPricedOutfitByCategoryUsecase findLowestPricedOutfitByCategoryUsecase;

	@GetMapping("/api/v1/categories/outfit/lowest-priced")
	public DataResponse<OutfitResponse> findLowestPricedOutfit() {
		OutfitResponse outfitResponse = findLowestPricedOutfitByCategoryUsecase
			.findLowestPricedOutfit();

		return DataResponse.from(outfitResponse);
	}
}
