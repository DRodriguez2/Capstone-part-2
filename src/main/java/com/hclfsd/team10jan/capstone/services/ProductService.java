package com.hclfsd.team10jan.capstone.services;

import java.util.List;
import java.util.Optional;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hclfsd.team10jan.capstone.entities.Album;
import com.hclfsd.team10jan.capstone.entities.Category;
import com.hclfsd.team10jan.capstone.entities.Genre;
import com.hclfsd.team10jan.capstone.entities.Product;
import com.hclfsd.team10jan.capstone.entities.Result;
import com.hclfsd.team10jan.capstone.entities.Track;
import com.hclfsd.team10jan.capstone.repositories.AlbumRepository;
import com.hclfsd.team10jan.capstone.repositories.CategoryRepository;
import com.hclfsd.team10jan.capstone.repositories.ProductRepository;
import com.hclfsd.team10jan.capstone.repositories.TrackRepository;

@Repository
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private TrackRepository trackRepository;
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	public void saveTrack(String type, String title, String artist, Double price, Category category, Genre genre,
			String description) {
		Product product = new Product();
		product.setPrice(price);
		product.setArtist(artist);
		product.setType(type);
		
		Category c1 = categoryRepository.findByNameAndGenre(category.getName(), genre);
		System.out.println("C1: " + c1);
		System.out.println("Category is : " + c1 + " and genre is " + genre);
		
		if (c1 == null) {
			c1 = new Category();
			c1.setName(category.getName());
			c1.setGenre(genre);
			categoryRepository.save(c1);
		}else {
			c1 = category;
		}
		product.setCategory(c1);
		
		//track
		Track track = new Track();
		track.setPrice(price);
		track.setTitle(title);
		track.setDescription(description);
		
		track.setProduct(product);
		productRepository.save(product);
		trackRepository.save(track);
		
	}
	
	public void saveAlbum(String type, String title, String artist, Double price, Category category, Genre genre,
			String description) {
		Product product = new Product();
		product.setPrice(price);
		product.setArtist(artist);
		product.setType(type);
		
		Category c1 = categoryRepository.findByNameAndGenre(category.getName(), genre);
		if (c1 == null) {
			c1 = new Category();
			c1.setName(category.getName());
			c1.setGenre(genre);
			categoryRepository.save(c1);
		}else {
			c1 = category;
		}
		product.setCategory(c1);
		
		Album album = new Album();
		album.setTitle(title);
		album.setDescription(description);
		
		album.setProduct(product);
		
		productRepository.save(product);
		albumRepository.save(album);
	}

	public Iterable<Result> getAll() {
		List<Result> results= new ArrayList<>();
		Iterable<Product> products = productRepository.findAll();
		for (Product product : products) {
			//System.out.println(product.getCategory());
			Result res = new Result();
			
			res.setPid(product.getId());
			res.setType(product.getType());
			res.setArtist(product.getArtist());
			res.setPrice(product.getPrice());
			res.setCategory(product.getCategory());
			
			if (product.getType().equals("Track")) {
				Track track = trackRepository.findByProduct(product);
				if (track != null) {
					res.setTid(track.getId());
					res.setTitle(track.getTitle());
					res.setDescription(track.getDescription());
				}
			}else if (product.getType().equals("Album")){
				Album album = albumRepository.findByProduct(product);
				if (album != null) {
//					System.out.println("Album: " + album);
					res.setAid(album.getId());
					res.setTitle(album.getTitle());
					res.setDescription(album.getDescription());
				}
			}
			//System.out.println(res);
			results.add(res);
		}
		return results;
	}

	public Result findById(Integer id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			Result res = new Result();
			Product p = product.get();
			res.setPid(p.getId());
			res.setType(p.getType());
			res.setArtist(p.getArtist());
			res.setPrice(p.getPrice());
			res.setCategory(p.getCategory());
			res.setGenre(p.getCategory().getGenre());
			
			if (p.getType().equals("Track")) {
				Track track = trackRepository.findByProduct(p);
				if (track != null) {
					res.setTid(track.getId());
					res.setTitle(track.getTitle());
					res.setDescription(track.getDescription());
				}
			}else if (p.getType().equals("Album")){
				Album album = albumRepository.findByProduct(p);
				if (album != null) {
					res.setAid(album.getId());
					res.setTitle(album.getTitle());
					res.setDescription(album.getDescription());
				}
			}
			
			return res;
		}
		return null;
	}

	public void updateTrack(Result res) {
		
		Category c1 = categoryRepository.findByNameAndGenre(res.getCategory().getName(), res.getGenre());
		System.out.println("C1: " + c1);
		System.out.println("Category is : " + c1 + " and genre is " + res.getGenre());

		if (c1 == null) {
			c1 = new Category();
			c1.setName(res.getCategory().getName());
			c1.setGenre(res.getCategory().getGenre());
			categoryRepository.save(c1);
		}
		
		
		Optional<Product> product = productRepository.findById(res.getPid());
		if (product.isPresent()) {
			product.get().setPrice(res.getPrice());
			product.get().setArtist(res.getArtist());
			product.get().setCategory(c1);
			productRepository.save(product.get());
		}
		
		Optional<Track> track = trackRepository.findById(res.getTid());
		if (track.isPresent()) {
			track.get().setTitle(res.getTitle());
			track.get().setDescription(res.getDescription());
			track.get().setPrice(res.getPrice());
			if (product.isPresent())
				track.get().setProduct(product.get());
			trackRepository.save(track.get());
		}
	}

	public void updateAlbum(Result res) {
		Category c1 = categoryRepository.findByNameAndGenre(res.getCategory().getName(), res.getGenre());
		if (c1 == null) {
			c1 = new Category();
			c1.setName(res.getCategory().getName());
			c1.setGenre(res.getGenre());
			categoryRepository.save(c1);	
		}
		
		
		Optional<Product> product = productRepository.findById(res.getPid());
		if (product.isPresent()) {
			product.get().setPrice(res.getPrice());
			product.get().setArtist(res.getArtist());
			product.get().setCategory(c1);
			
			productRepository.save(product.get());
		}
		
		Optional<Album> album = albumRepository.findById(res.getAid());
		if (album.isPresent()) {
			album.get().setTitle(res.getTitle());
			album.get().setDescription(res.getDescription());
			if (product.isPresent())
				album.get().setProduct(product.get());
			albumRepository.save(album.get());
		}
		
	}

	public void deleteProduct(Result res) {
		if (res.getType().indexOf("Track") != -1) {
			trackRepository.deleteById(res.getTid());
		}else {
			albumRepository.deleteById(res.getAid());
		}
		
		productRepository.deleteById(res.getPid());
	}
	
	
}
