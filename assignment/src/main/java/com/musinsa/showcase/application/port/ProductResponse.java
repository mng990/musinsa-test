package com.musinsa.showcase.application.port;

public record ProductResponse(
	String category,
	String brand,
	Long price
) {
}
