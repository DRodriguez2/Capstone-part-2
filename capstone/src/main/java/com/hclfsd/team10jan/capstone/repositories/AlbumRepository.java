package com.hclfsd.team10jan.capstone.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hclfsd.team10jan.capstone.entities.Album;
import com.hclfsd.team10jan.capstone.entities.Product;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer>{
	public Album findByProduct(Product product);

}