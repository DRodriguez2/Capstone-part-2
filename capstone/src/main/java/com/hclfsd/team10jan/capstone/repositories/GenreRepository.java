package com.hclfsd.team10jan.capstone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hclfsd.team10jan.capstone.entities.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer>{
	public Genre findByName(String name);
}