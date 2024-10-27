package com.musinsa.showcase.adapter.in;

import org.springframework.web.bind.annotation.RestController;

import com.musinsa.showcase.application.port.in.FindLowestPricedOutfitByCategoryUsecase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryController {
	private final FindLowestPricedOutfitByCategoryUsecase findLowestPricedOutfitByCategoryUsecase;
}
