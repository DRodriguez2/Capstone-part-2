package com.hclfsd.team10jan.capstone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cartproduct")
@Data
@NoArgsConstructor
public class CartProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cartproduct_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
}
