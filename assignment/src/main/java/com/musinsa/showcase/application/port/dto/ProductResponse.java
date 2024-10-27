package com.musinsa.showcase.application.port.dto;

public record ProductResponse(
	String category,
	String brand,
	Long price
) { }
