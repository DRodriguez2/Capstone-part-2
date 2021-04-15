package com.hclfsd.team10jan.capstone.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hclfsd.team10jan.capstone.entities.Genre;
import com.hclfsd.team10jan.capstone.repositories.GenreRepository;


@Service
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepository;
	

	public Iterable<Genre> getAllGenres() {
		return genreRepository.findAll();
	}

	public void deleteGenre(Integer id) {
		genreRepository.deleteById(id);
	}
	
	public Genre saveGenre(Genre genre) {
		Genre genre1 = genreRepository.findByName(genre.getName());
		if (genre1 == null)
			return genreRepository.save(genre);
		return genre;
	}

	public Genre findById(Integer id) {
		Optional<Genre> genre = genreRepository.findById(id);
		return genre.isPresent() ? genre.get() : null;
	}
	
}

