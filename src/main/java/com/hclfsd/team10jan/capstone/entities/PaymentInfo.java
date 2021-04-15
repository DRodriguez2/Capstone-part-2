package com.hclfsd.team10jan.capstone.entities;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="payment_info")
@Data
@NoArgsConstructor
public class PaymentInfo {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="payment_info_id")
    private Integer id;
	
	@Column(name="card_number")
	private BigInteger cardNumber;
	
	@Column(name="expiration")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiration;
	
	@Column(name="cvv")
	private Integer cvv;
	
	@Column(name="address")
	private String address;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public PaymentInfo(BigInteger cardNumber, LocalDate expiration, Integer cvv, String address) {
		this.cardNumber = cardNumber;
		this.expiration = expiration;
		this.cvv = cvv;
		this.address = address;
	}
}