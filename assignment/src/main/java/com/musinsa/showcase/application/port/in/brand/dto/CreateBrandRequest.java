package com.musinsa.showcase.application.port.in.brand.dto;

import jakarta.validation.constraints.NotNull;

public record CreateBrandRequest(
	@NotNull(message = "name is null")
	String name
)
{ }
