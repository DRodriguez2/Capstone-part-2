package com.hclfsd.team10jan.capstone.entities;


import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="music")
@Data
@NoArgsConstructor
public class Music {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Album album;

    private int trackNumber;

    private BigDecimal price;
}