package com.hclfsd.team10jan.capstone.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="transactions")
@Data
@NoArgsConstructor
public class Transaction {
 	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private Integer id;
 	
 	@OneToOne
 	@JoinColumn(name="cart_id")
 	private Cart cart;
 	
 	@Column(name="purchased_on")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate purchasedOn;
 	
 	@ManyToOne
 	@JoinColumn(name="payment_info_id")
 	private PaymentInfo paymentInfo;
 	
}
