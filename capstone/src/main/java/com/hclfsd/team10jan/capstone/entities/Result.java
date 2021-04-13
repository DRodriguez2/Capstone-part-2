package com.hclfsd.team10jan.capstone.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result {
	private Integer pid;
	private Integer tid;
	private Integer aid;
	
	private String title;
	private String artist;
	private Genre genre;
	private String type;
	private Double price;
	private String description;
	
	private Category category;

	
	
}
