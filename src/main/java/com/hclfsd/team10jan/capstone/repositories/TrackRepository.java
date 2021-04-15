package com.hclfsd.team10jan.capstone.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hclfsd.team10jan.capstone.entities.Product;
import com.hclfsd.team10jan.capstone.entities.Track;

@Repository
public interface TrackRepository extends CrudRepository<Track, Integer>{
	public Track findByProduct(Product product);

}