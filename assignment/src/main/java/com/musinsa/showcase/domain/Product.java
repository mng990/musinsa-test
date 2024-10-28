package com.musinsa.showcase.domain;

import static lombok.AccessLevel.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.musinsa.common.entity.BaseEntity;

@Entity
@Getter
@Table(name = "products")
@NoArgsConstructor(access = PROTECTED)
public class Product extends BaseEntity {

	@Id @Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	public void setCategory(Category category) {
		this.category = category;
		if(!category.getProducts().contains(this)) {
			category.getProducts().add(this);
		}
	}

	public void setBrand(Brand brand){
		this.brand = brand;
		if(!brand.getProducts().contains(this)){
			brand.getProducts().add(this);
		}
	}

	@Builder
	private Product(Brand brand, Category category, Long price) {
		setBrand(brand);
		setCategory(category);
		this.price = price;
	}
}
