package com.musinsa.showcase.application.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.musinsa.common.config.DataInitConfig;
import com.musinsa.common.exception.ApiException;
import com.musinsa.showcase.adapter.out.persistence.BrandPersistenceAdapter;
import com.musinsa.showcase.adapter.out.persistence.BrandRepository;
import com.musinsa.showcase.adapter.out.persistence.CategoryPersistenceAdapter;
import com.musinsa.showcase.adapter.out.persistence.CategoryRepository;
import com.musinsa.showcase.adapter.out.persistence.ProductPersistenceAdapter;
import com.musinsa.showcase.adapter.out.persistence.ProductRepository;
import com.musinsa.showcase.application.port.in.brand.dto.CreateBrandRequest;
import com.musinsa.showcase.application.port.in.brand.dto.DeleteBrandRequest;
import com.musinsa.showcase.application.port.in.product.dto.CreateProductRequest;
import com.musinsa.showcase.application.port.in.product.dto.DeleteProductRequest;
import com.musinsa.showcase.application.port.out.brand.CreateBrandPort;
import com.musinsa.showcase.application.port.out.brand.DeleteBrandPort;
import com.musinsa.showcase.application.port.out.brand.ReadBrandPort;
import com.musinsa.showcase.domain.Brand;
import com.musinsa.showcase.domain.Product;
import com.musinsa.showcase.domain.Category;

import jakarta.persistence.EntityManager;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {
	@Mock
	private CreateBrandPort createBrandPort;

	@InjectMocks
	private BrandService brandService;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	// BrandService Tests
	@Test
	void saveBrand() {
		Brand brand = Brand.builder().name("New Brand").build();
		CreateBrandRequest command = new CreateBrandRequest(brand.getName());

		lenient().when(createBrandPort.save(any(Brand.class))).thenAnswer(invocation -> {
			Brand savedBrand = invocation.getArgument(0);
			savedBrand.setId(1L);
			return savedBrand;
		});

		Long savedBrand = brandService.save(command);

		assertNotNull(savedBrand);
	}

	@Test
	void updateBrand() {
		Brand brand = Brand
			.builder()
			.name("Updated Brand")
			.build();

		brand.update("update");
		assertEquals("update", brand.getName());
	}
}
