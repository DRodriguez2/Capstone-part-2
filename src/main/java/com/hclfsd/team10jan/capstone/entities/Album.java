package com.hclfsd.team10jan.capstone.entities;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="album")
@Data
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="album_id")
    private Integer id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
