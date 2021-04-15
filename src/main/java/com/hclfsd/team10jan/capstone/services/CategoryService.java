package com.hclfsd.team10jan.capstone.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hclfsd.team10jan.capstone.entities.Category;
import com.hclfsd.team10jan.capstone.repositories.CategoryRepository;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	

	public Iterable<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}
	
	public Category saveCategory(Category category) {
		Category cat = categoryRepository.findByNameAndGenre(category.getName(), category.getGenre());
		return (cat==null) ? categoryRepository.save(category) : cat;
	}

	public Category findById(Integer id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.isPresent() ? category.get() : null;
	}
	
}

