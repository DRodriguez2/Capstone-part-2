package com.hclfsd.team10jan.capstone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hclfsd.team10jan.capstone.entities.Cart;
import com.hclfsd.team10jan.capstone.entities.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>{
	public Transaction findByCart(Cart cart);
}
