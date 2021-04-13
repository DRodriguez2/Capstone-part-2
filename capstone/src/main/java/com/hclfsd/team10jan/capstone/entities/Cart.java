package com.hclfsd.team10jan.capstone.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cart")
@Data
@NoArgsConstructor
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="is_purchased")
	private Boolean isPurchased;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {
				CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH	
			})
	@JoinTable(
				name="cart_product",
				joinColumns=@JoinColumn(name="cart_id"),
				inverseJoinColumns=@JoinColumn(name="product_id")
			)
	private List<Product> products;
	
	public void addProduct(Product product) {
		if (products == null) {
			products = new ArrayList<>();
		}
		products.add(product);
	}
}
