package com.hclfsd.team10jan.capstone.repositories;
import org.springframework.data.repository.CrudRepository;

import com.hclfsd.team10jan.capstone.entities.Music;
public interface MusicRepository extends CrudRepository<Music, Integer>{
}