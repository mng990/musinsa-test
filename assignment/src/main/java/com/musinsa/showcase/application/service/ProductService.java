package com.musinsa.showcase.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musinsa.common.exception.ApiException;
import com.musinsa.common.exception.ErrorCode;
import com.musinsa.common.mapper.ProductMapper;
import com.musinsa.showcase.application.port.in.product.dto.CreateProductRequest;
import com.musinsa.showcase.application.port.in.product.dto.DeleteProductRequest;
import com.musinsa.showcase.application.port.in.product.dto.UpdateProductRequest;
import com.musinsa.showcase.application.port.out.product.dto.MinMaxProductByCategoryResponse;
import com.musinsa.showcase.application.port.in.category.FindCategoryUsecase;
import com.musinsa.showcase.application.port.in.product.CreateProductUsecase;
import com.musinsa.showcase.application.port.in.product.DeleteProductUsecase;
import com.musinsa.showcase.application.port.in.product.FindLowestAndHighestProductsByCategoryUsecase;
import com.musinsa.showcase.application.port.in.product.UpdateProductUsecase;
import com.musinsa.showcase.application.port.out.brand.ReadBrandPort;
import com.musinsa.showcase.application.port.out.category.ReadCategoryPort;
import com.musinsa.showcase.application.port.out.product.CreateProductPort;
import com.musinsa.showcase.application.port.out.product.DeleteProductPort;
import com.musinsa.showcase.application.port.out.product.ReadProductPort;
import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService implements
	FindCategoryUsecase,
	FindLowestAndHighestProductsByCategoryUsecase,
	CreateProductUsecase,
	UpdateProductUsecase,
	DeleteProductUsecase {

	// category
	private final ReadCategoryPort readCategoryPort;
	// product
	private final ReadProductPort readProductPort;
	private final CreateProductPort createProductPort;
	private final DeleteProductPort deleteProductPort;
	// brand
	private final ReadBrandPort readBrandPort;

	@Override
	public Category byName(String name) {
		return readCategoryPort
			.findByName(name)
			.orElseThrow(() -> ApiException.from(ErrorCode.CATEGORY_NOT_FOUND));
	}

	@Override
	public MinMaxProductByCategoryResponse findLowestAndHighestProductByCategory(Category category) {
		Product minProduct = readProductPort.findMinProductByCategory(category),
				maxProduct = readProductPort.findMaxProductByCategory(category);

		return new MinMaxProductByCategoryResponse(
			category.getName(),
			ProductMapper.toProductOfCategoryResponse(minProduct),
			ProductMapper.toProductOfCategoryResponse(maxProduct)
		);
	}

	@Override
	@Transactional
	public void delete(DeleteProductRequest deleteProductRequest) {
		Product product = readProductPort
			.findProduct(deleteProductRequest.productId());

		if(!readProductPort.exists(product)){
			throw ApiException.from(ErrorCode.PRODUCT_NOT_FOUND);
		}

		product.unlinkProduct();
		deleteProductPort.delete(product);
	}

	@Override
	@Transactional
	public void update(UpdateProductRequest updateProductRequest) {
		Product product = readProductPort
			.findProduct(updateProductRequest.productId());

		Category updateCategory = readCategoryPort
			.findById(updateProductRequest.categoryId())
			.orElseThrow(() -> ApiException.from(ErrorCode.CATEGORY_NOT_FOUND));

		Brand updateBrand = readBrandPort
			.findById(updateProductRequest.brandId())
			.orElseThrow(() -> ApiException.from(ErrorCode.BRAND_NOT_FOUND));

		if(!readProductPort.exists(product)){
			throw ApiException.from(ErrorCode.PRODUCT_NOT_FOUND);
		}

		product.update(updateCategory, updateBrand, updateProductRequest.price());
		System.out.println("updateBrand = " + updateBrand);
	}

	@Override
	@Transactional
	public Long save(CreateProductRequest createProductRequest) {
		Brand brand = readBrandPort
			.findById(createProductRequest.brandId())
			.orElseThrow(() -> ApiException.from(ErrorCode.BRAND_NOT_FOUND));

		Category category = readCategoryPort
			.findById(createProductRequest.categoryId())
			.orElseThrow(() -> ApiException.from(ErrorCode.CATEGORY_NOT_FOUND));

		Product product = Product
			.builder()
			.brand(brand)
			.category(category)
			.price(createProductRequest.price())
			.build();

		createProductPort.save(product);

		return product.getId();
	}
}
