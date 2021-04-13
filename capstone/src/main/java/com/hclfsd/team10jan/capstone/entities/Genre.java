package com.hclfsd.team10jan.capstone.entities;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="genre")
@Data
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="genre_id")
    private Integer id;
    
    @Column(name="name")
    private String name;

}