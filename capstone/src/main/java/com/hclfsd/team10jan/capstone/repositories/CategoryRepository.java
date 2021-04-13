package com.hclfsd.team10jan.capstone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hclfsd.team10jan.capstone.entities.Category;
import com.hclfsd.team10jan.capstone.entities.Genre;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
	public Category findByNameAndGenre(String name, Genre genre);
}
