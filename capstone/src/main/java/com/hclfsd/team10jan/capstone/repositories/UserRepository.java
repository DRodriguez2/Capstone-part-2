package com.hclfsd.team10jan.capstone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hclfsd.team10jan.capstone.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUsername(String username);
	
}
