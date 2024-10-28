package com.musinsa.showcase.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.common.mapper.PriceMapper;
import com.musinsa.common.mapper.ProductMapper;
import com.musinsa.showcase.application.port.in.brand.dto.CreateBrandRequest;
import com.musinsa.showcase.application.port.in.brand.dto.DeleteBrandRequest;
import com.musinsa.showcase.application.port.in.brand.dto.UpdateBrandRequest;
import com.musinsa.showcase.application.port.out.brand.CreateBrandPort;
import com.musinsa.showcase.application.port.out.brand.DeleteBrandPort;
import com.musinsa.showcase.application.port.out.brand.ReadBrandPort;
import com.musinsa.showcase.application.port.out.brand.ReadBrandUsecase;
import com.musinsa.showcase.application.port.out.brand.dto.OutfitOfBrandResponse;
import com.musinsa.showcase.application.port.out.brand.dto.OutfitOfLowestPricedBrandResponse;
import com.musinsa.showcase.application.port.out.brand.dto.ProductOfBrandResponse;
import com.musinsa.showcase.application.port.in.brand.CreateBrandUsecase;
import com.musinsa.showcase.application.port.in.brand.DeleteBrandUsecase;
import com.musinsa.showcase.application.port.in.brand.UpdateBrandUsecase;
import com.musinsa.showcase.application.port.in.product.FindLowestPricedOutfitByBrandUsecase;
import com.musinsa.showcase.application.port.out.product.DeleteProductPort;
import com.musinsa.showcase.domain.Brand;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BrandService implements
	FindLowestPricedOutfitByBrandUsecase,
	ReadBrandUsecase,
	CreateBrandUsecase,
	UpdateBrandUsecase,
	DeleteBrandUsecase {

	private final CreateBrandPort createBrandPort;
	private final ReadBrandPort readBrandPort;
	private final DeleteBrandPort deleteBrandPort;

	private final DeleteProductPort deleteProductPort;

	@Override
	public OutfitOfLowestPricedBrandResponse findOutfitOfLowestPricedBrand() {
		Brand brand = readBrandPort
			.findLowestPricedBrand();

		List<ProductOfBrandResponse> outfit =
			readBrandPort
				.findLowestPricedProductsByBrand(brand)
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

	@Override
	@Transactional
	public Long save(CreateBrandRequest createBrandRequest) {
		Brand brand = Brand
			.builder()
			.name(createBrandRequest.name())
			.build();

		return createBrandPort.save(brand);
	}

	@Override
	@Transactional
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		Brand brand = readBrandPort
			.findById(deleteBrandRequest.brandId())
			.orElseThrow(() -> ApiException.from(ErrorCode.BRAND_NOT_FOUND));

		deleteProductPort.deleteAllByBrand(brand);
		deleteBrandPort.delete(brand);
	}

	@Override
	@Transactional
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = readBrandPort
			.findById(updateBrandRequest.brandId())
			.orElseThrow(() -> ApiException.from(ErrorCode.BRAND_NOT_FOUND));

		brand.update(updateBrandRequest.name());
	}

	@Override
	public Brand findById(Long id) {
		return readBrandPort.findById(id)
			.orElseThrow(() -> ApiException.from(ErrorCode.BRAND_NOT_FOUND));
	}
}
