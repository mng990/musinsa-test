package com.musinsa.showcase.application.port.dto;

import java.util.List;

public record OutfitResponse(
	List<ProductResponse> productResponses,
	Long totalPrice
) { }
