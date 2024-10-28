package com.musinsa.showcase.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.common.mapper.PriceMapper;
import com.musinsa.common.mapper.ProductMapper;
import com.musinsa.showcase.application.port.dto.brand.OutfitOfBrandResponse;
import com.musinsa.showcase.application.port.dto.product.OutfitOfLowestPricedBrandResponse;
import com.musinsa.showcase.application.port.dto.brand.ProductOfBrandResponse;
import com.musinsa.showcase.application.port.in.product.FindLowestPricedOutfitByBrandUsecase;
import com.musinsa.showcase.application.port.out.ReadBrandPort;
import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BrandService implements
	FindLowestPricedOutfitByBrandUsecase {

	private final ReadBrandPort readBrandPort;

	@Override
	public OutfitOfLowestPricedBrandResponse findOutfitOfLowestPricedBrand() {
		Brand brand = readBrandPort
			.loadLowestPricedBrand();

		List<ProductOfBrandResponse> outfit =
			readBrandPort
				.loadLowestPricedProductsByBrand(brand)
				.stream()
				.map(ProductMapper::toProductOfBrandResponse)
				.toList();

		if(outfit.isEmpty()){
			throw ApiException.from(ErrorCode.OUTFIT_IS_EMPTY);
		}

		Long totalPrice = outfit
			.stream()
			.map((p) -> PriceMapper.stringToLong(p.price()))
			.reduce(0L, Long::sum);

		return new OutfitOfLowestPricedBrandResponse(
			new OutfitOfBrandResponse(brand.getName(), outfit, String.format("%,d", totalPrice))
		);
	}
}
