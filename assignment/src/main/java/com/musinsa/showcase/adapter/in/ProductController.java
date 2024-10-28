package com.musinsa.showcase.adapter.in;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musinsa.common.dto.DataResponse;
import com.musinsa.showcase.application.port.in.product.DeleteProductUsecase;
import com.musinsa.showcase.application.port.in.product.UpdateProductUsecase;
import com.musinsa.showcase.application.port.in.product.dto.CreateProductRequest;
import com.musinsa.showcase.application.port.in.product.dto.DeleteProductRequest;
import com.musinsa.showcase.application.port.in.product.dto.UpdateProductRequest;
import com.musinsa.showcase.application.port.out.product.dto.MinMaxProductByCategoryResponse;
import com.musinsa.showcase.application.port.in.category.FindCategoryUsecase;
import com.musinsa.showcase.application.port.in.product.CreateProductUsecase;
import com.musinsa.showcase.application.port.in.product.FindLowestAndHighestProductsByCategoryUsecase;
import com.musinsa.showcase.domain.Category;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

	private final CreateProductUsecase createProductUsecase;
	private final UpdateProductUsecase updateProductUsecase;
	private final DeleteProductUsecase deleteProductUsecase;
	private final FindLowestAndHighestProductsByCategoryUsecase findLowestAndHighestProductsByCategoryUsecase;
	private final FindCategoryUsecase findCategoryUsecase;

	@GetMapping("/min-max")
	public DataResponse<MinMaxProductByCategoryResponse> findMinMaxProducts(@RequestParam("categoryName") String categoryName) {
		Category category = findCategoryUsecase.byName(categoryName);

		MinMaxProductByCategoryResponse minMaxProductByCategoryResponse =
			findLowestAndHighestProductsByCategoryUsecase
			.findLowestAndHighestProductByCategory(category);

		return DataResponse.from(minMaxProductByCategoryResponse);
	}

	@PostMapping
	public DataResponse<Void> createProduct(@RequestBody CreateProductRequest createProductRequest) {
		createProductUsecase.save(createProductRequest);
		return DataResponse.created();
	}

	@PutMapping
	public DataResponse<Void> updateProduct(@RequestBody UpdateProductRequest createProductRequest) {
		updateProductUsecase.update(createProductRequest);
		return DataResponse.ok();
	}

	@DeleteMapping
	public DataResponse<Void> deleteProduct(@RequestBody DeleteProductRequest deleteProductRequest) {
		deleteProductUsecase.delete(deleteProductRequest);
		return DataResponse.noContent();
	}
}
