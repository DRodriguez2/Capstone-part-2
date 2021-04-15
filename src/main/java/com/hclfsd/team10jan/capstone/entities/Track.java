package com.hclfsd.team10jan.capstone.entities;


import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="track")
@Data
@NoArgsConstructor
public class Track {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="track_id")
    private Integer id;

    @Column(name="title")
    private String title;
    
    @Column(name="description")
    private String description;
    
    @Column(name="price")
    private Double price;
    
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}