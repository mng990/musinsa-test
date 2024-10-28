package com.musinsa.showcase.adapter.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musinsa.common.dto.DataResponse;
import com.musinsa.showcase.application.port.dto.MinMaxProductByCategoryResponse;
import com.musinsa.showcase.application.port.in.category.FindCategoryUsecase;
import com.musinsa.showcase.application.port.in.product.FindLowestAndHighestProductsByCategoryUsecase;
import com.musinsa.showcase.domain.Category;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

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

}
