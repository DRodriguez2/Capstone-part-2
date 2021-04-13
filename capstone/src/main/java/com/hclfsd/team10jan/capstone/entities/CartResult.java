package com.hclfsd.team10jan.capstone.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartResult {
	private Integer cid;
	private Integer pid;
	private Integer tid;
	private Integer aid;
	private String title;
	private String type;
	private Double price;
	
	private Integer quantity;
	private Double totalPrice;
}
