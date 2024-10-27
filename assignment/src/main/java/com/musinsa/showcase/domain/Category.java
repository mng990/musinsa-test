package com.musinsa.showcase.domain;

import static lombok.AccessLevel.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "categories")
@NoArgsConstructor(access = PROTECTED)
public class Category {

	@Id @Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Product> products = new ArrayList<>();

	public void setProduct(Product product) {
		this.products.add(product);
		if(product.getCategory() != this) {
			product.setCategory(this);
		}
	}

	@Builder
	public Category(String name) {
		this.name = name;
	}
}
