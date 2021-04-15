package com.hclfsd.team10jan.capstone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hclfsd.team10jan.capstone.entities.Cart;
import com.hclfsd.team10jan.capstone.entities.User;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
	public Iterable<Cart> findByUser(User user);
}
