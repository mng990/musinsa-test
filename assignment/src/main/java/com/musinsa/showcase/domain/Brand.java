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

import com.musinsa.common.entity.BaseEntity;

@Entity
@Getter
@Table(name = "brands")
@NoArgsConstructor(access = PROTECTED)
public class Brand extends BaseEntity {

	@Id @Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "brand", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
	private List<Product> products = new ArrayList<>();

	public void setBrand(Product product) {
		this.products.add(product);
		if(product.getBrand() != this) {
			product.setBrand(this);
		}
	}

	public void removeProduct(Product product) {
		if(product.getBrand() == this) {
			this.products.remove(product);
			product.setBrand(null);
		}
	}

	public void update(String name) {
		this.name = name;
	}

	@Builder(toBuilder = true)
	private Brand(String name) {
		this.name = name;
	}
}
