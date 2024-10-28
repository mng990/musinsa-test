// Data Initialization Configuration
package com.musinsa.common.config;

import com.musinsa.common.mapper.BrandMapper;
import com.musinsa.showcase.adapter.out.persistence.BrandRepository;
import com.musinsa.showcase.adapter.out.persistence.CategoryRepository;
import com.musinsa.showcase.adapter.out.persistence.ProductRepository;
import com.musinsa.showcase.application.port.in.brand.dto.CreateBrandRequest;
import com.musinsa.showcase.application.port.in.product.dto.CreateProductRequest;
import com.musinsa.showcase.application.port.out.brand.CreateBrandPort;
import com.musinsa.showcase.application.port.out.category.CreateCategoryPort;
import com.musinsa.showcase.application.port.out.product.CreateProductPort;
import com.musinsa.showcase.application.service.BrandService;
import com.musinsa.showcase.application.service.CategoryService;
import com.musinsa.showcase.application.service.ProductService;
import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Category;
import com.musinsa.showcase.domain.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.parser.Entity;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DataInitConfig {

	private final ProductService productService;
	private final CategoryService categoryService;
	private final BrandService brandService;
	private final EntityManager em;

	@Bean
	public CommandLineRunner initDatabase(CategoryRepository categoryRepository, BrandRepository brandRepository, ProductRepository productRepository) {
		return args -> {
			List<Category> categories = List.of(
				Category.builder().name("상의").build(),
				Category.builder().name("아우터").build(),
				Category.builder().name("바지").build(),
				Category.builder().name("스니커즈").build(),
				Category.builder().name("가방").build(),
				Category.builder().name("모자").build(),
				Category.builder().name("양말").build(),
				Category.builder().name("액세서리").build()
			);
			List<Category> savedCategories = categoryRepository.saveAll(categories);

			List<Brand> brands = List.of(
				Brand.builder().name("A").build(),
				Brand.builder().name("B").build(),
				Brand.builder().name("C").build(),
				Brand.builder().name("D").build(),
				Brand.builder().name("E").build(),
				Brand.builder().name("F").build(),
				Brand.builder().name("G").build(),
				Brand.builder().name("H").build(),
				Brand.builder().name("I").build()
			);

			List<Brand> savedBrands = brandRepository.saveAll(brands);

			Map<String, List<Long>> prices = Map.of(
				"상의", List.of(11200L, 10500L, 10000L, 10100L, 10700L, 11200L, 10500L, 10800L, 11400L),
				"아우터", List.of(5500L, 5900L, 6200L, 5100L, 5000L, 7200L, 5800L, 6300L, 6700L),
				"바지", List.of(4200L, 3800L, 3300L, 3000L, 3800L, 4000L, 3900L, 3100L, 3200L),
				"스니커즈", List.of(9000L, 9100L, 9200L, 9500L, 9900L, 9300L, 9700L, 9700L, 9500L),
				"가방", List.of(2000L, 2100L, 2200L, 2500L, 2300L, 2100L, 2200L, 2100L, 2400L),
				"모자", List.of(1700L, 2000L, 1900L, 1500L, 1800L, 1600L, 1700L, 1600L, 1700L),
				"양말", List.of(1800L, 2000L, 2200L, 2400L, 2100L, 2300L, 2100L, 2000L, 1700L),
				"액세서리", List.of(2300L, 2200L, 2100L, 2000L, 2100L, 1900L, 2000L, 2000L, 2400L)
			);

			List<CreateProductRequest> products = new ArrayList<>();
			for (Category category : savedCategories) {
				List<Long> categoryPrices = prices.get(category.getName());
				for (int j = 0; j < savedBrands.size(); j++) {
					products.add(new CreateProductRequest(brands.get(j).getId(), category.getId(), categoryPrices.get(j)));
				}
			}
			productService.saveAll(products);
		};
	}
}
