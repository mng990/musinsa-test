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

	@OneToMany(mappedBy = "brand", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Product> product = new ArrayList<>();

	public void setBrand(Product product) {
		this.product.add(product);
		if(product.getBrand() != this) {
			product.setBrand(this);
		}
	}

	@Builder
	private Brand(String name) {
		this.name = name;
	}
}
