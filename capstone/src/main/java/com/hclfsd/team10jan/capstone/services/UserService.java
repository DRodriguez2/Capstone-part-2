package com.hclfsd.team10jan.capstone.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hclfsd.team10jan.capstone.entities.User;
import com.hclfsd.team10jan.capstone.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	  

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public User findUserByUserName(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

	public User registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        return userRepository.save(user);
	}

}

