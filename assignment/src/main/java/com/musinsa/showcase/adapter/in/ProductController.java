package com.musinsa.showcase.adapter.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musinsa.common.dto.DataResponse;
import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.showcase.application.port.dto.OutfitResponse;
import com.musinsa.showcase.application.port.in.FindLowestPricedOutfitByCategoryUsecase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {

	private final FindLowestPricedOutfitByCategoryUsecase findLowestPricedOutfitByCategoryUsecase;

}
