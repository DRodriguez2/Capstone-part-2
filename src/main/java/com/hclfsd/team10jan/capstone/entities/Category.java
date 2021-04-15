package com.hclfsd.team10jan.capstone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="category")
@Data
@NoArgsConstructor
public class Category {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="category_id")
    private Integer id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="genre_id")
	private Genre genre;
}
