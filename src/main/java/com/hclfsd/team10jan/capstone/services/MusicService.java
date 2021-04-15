package com.hclfsd.team10jan.capstone.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hclfsd.team10jan.capstone.entities.Album;
import com.hclfsd.team10jan.capstone.entities.Cart;
import com.hclfsd.team10jan.capstone.entities.CartResult;
import com.hclfsd.team10jan.capstone.entities.Category;
import com.hclfsd.team10jan.capstone.entities.Genre;
import com.hclfsd.team10jan.capstone.entities.OrdersResult;
import com.hclfsd.team10jan.capstone.entities.PaymentInfo;
import com.hclfsd.team10jan.capstone.entities.Product;
import com.hclfsd.team10jan.capstone.entities.Result;
import com.hclfsd.team10jan.capstone.entities.Track;
import com.hclfsd.team10jan.capstone.entities.Transaction;
import com.hclfsd.team10jan.capstone.entities.User;
import com.hclfsd.team10jan.capstone.repositories.AlbumRepository;
import com.hclfsd.team10jan.capstone.repositories.CartRepository;
import com.hclfsd.team10jan.capstone.repositories.CategoryRepository;
import com.hclfsd.team10jan.capstone.repositories.PaymentInfoRepository;
import com.hclfsd.team10jan.capstone.repositories.ProductRepository;
import com.hclfsd.team10jan.capstone.repositories.TrackRepository;
import com.hclfsd.team10jan.capstone.repositories.TransactionRepository;
import com.hclfsd.team10jan.capstone.repositories.UserRepository;

@Service
public class MusicService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private TrackRepository trackRepository;
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private PaymentInfoRepository paymentInfoRepository;
	
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

	public void addProductToCart(Integer id, String username) {
		// Find all carts for the user.
		User user = userRepository.findByUsername(username);
		Iterable<Cart> carts = cartRepository.findByUser(user);
		
		
		// Find the cart with no-transaction 
		Cart cart = null;
		for (Cart c : carts) {
			if (transactionRepository.findByCart(c) == null) {
				cart = c;
				break;
			}
		}
		
		//Else create a new cart
		if (cart == null) {
			cart = new Cart();
			cart.setIsPurchased(false);
			cart.setUser(user);
		}
		
		//Add product to the cart.
		Optional<Product> p = productRepository.findById(id);
		if (p.isPresent()) {
			cart.addProduct(p.get());
			cartRepository.save(cart);
		}
	}

	public List<CartResult> getCartItems(String username) {
		// Find all carts for the user.
		User user = userRepository.findByUsername(username);
		Iterable<Cart> carts = cartRepository.findByUser(user);
		
		
		// Find the cart with no-transaction 
		Cart cart = null;
		for (Cart c : carts) {
			if (transactionRepository.findByCart(c) == null) {
				cart = c;
				break;
			}
		}
		
		//Else create a new cart
		if (cart == null) {
			return new ArrayList<>();
		}
		
		List<Product> products = cart.getProducts();
		List<CartResult> res = new ArrayList<>();
		
		Map<Integer, Integer> map = new HashMap<>();
		for (Product p : products) {
			if (map.containsKey(p.getId())) {
				CartResult cr = res.get(map.get(p.getId()));
				cr.setQuantity(cr.getQuantity()+1);
				cr.setTotalPrice(cr.getPrice() * cr.getQuantity());
				continue;
			}
			
			map.put(p.getId(), res.size());
			CartResult cr = new CartResult();
			cr.setCid(cart.getId());
			cr.setPid(p.getId());
			cr.setPrice(p.getPrice());
			cr.setQuantity(1);
			cr.setTotalPrice(cr.getPrice());
			
			if (p.getType().equals("Track")) {
				Track track = trackRepository.findByProduct(p);
				if (track != null) {
					cr.setTid(track.getId());
					cr.setTitle(track.getTitle());
				}
			}else if (p.getType().equals("Album")) {
				Album album = albumRepository.findByProduct(p);
				if (album != null) {
					cr.setAid(album.getId());
					cr.setTitle(album.getTitle());
				}
			}
			
			res.add(cr);
			
		}
		return res;
	}

	public void deleteCartItem(Integer cid, Integer pid) {
		Optional<Cart> cart = cartRepository.findById(cid);
		if (cart.isPresent()) {
			List<Product> products = cart.get().getProducts();
			Set<Integer> indexes = new HashSet<>();
			//System.out.println(products);
			for (int i = 0; i < products.size(); ++i) {
				if (products.get(i).getId() == pid) {
					indexes.add(i);
				}
			}
			
			List<Product> newProducts = new ArrayList<Product>();
			for (int i = 0; i < products.size(); ++i) {
				if (!indexes.contains(i))
					newProducts.add(products.get(i));
			}
			cart.get().setProducts(newProducts);
			cartRepository.save(cart.get());
		}
	}

	public void deleteCartItems(String username) {
		// Find all carts for the user.
			User user = userRepository.findByUsername(username);
			Iterable<Cart> carts = cartRepository.findByUser(user);
			
			
			// Find the cart with no-transaction 
			Cart cart = null;
			for (Cart c : carts) {
				if (transactionRepository.findByCart(c) == null) {
					cart = c;
					break;
				}
			}
			
		if (cart != null) {
			cart.setProducts(null);
			cartRepository.save(cart);
		}
	}

	public Double getTotal(List<CartResult> results) {
		Double total = 0.0;
		for (CartResult c : results) {
			total += c.getTotalPrice();
		}
		return total;
	}

	public Integer getCart(String username) {
		// Find all carts for the user.
		User user = userRepository.findByUsername(username);
		Iterable<Cart> carts = cartRepository.findByUser(user);
		
		
		// Find the cart with no-transaction 
		Cart cart = null;
		for (Cart c : carts) {
			if (transactionRepository.findByCart(c) == null) {
				cart = c;
				break;
			}
		}
		
		//Else create a new cart
		if (cart == null) {
			return null;
		}
		return cart.getId();
	}

	public void savePaymentAndCommitTransaction(String username, Integer cid, BigInteger cardNumber, Integer cvv,
			LocalDate expiration, String address) {
		User user = userRepository.findByUsername(username);
		PaymentInfo paymentInfo = paymentInfoRepository.findByCardNumberAndCvv(cardNumber, cvv);
		
		if (paymentInfo == null) {
			paymentInfo = new PaymentInfo(cardNumber, expiration, cvv, address);
			paymentInfo.setUser(user);
		}else {
			paymentInfo.setAddress(address);
			paymentInfo.setExpiration(expiration);
			paymentInfo.setUser(user);
		}
		
		paymentInfoRepository.save(paymentInfo);
		
		//Create Transaction
		Optional<Cart> cart = cartRepository.findById(cid);
		if (cart.isPresent()) {
			Transaction transaction = new Transaction();
			transaction.setCart(cart.get());
			transaction.setPurchasedOn(LocalDate.now());
			transaction.setPaymentInfo(paymentInfo);
			transactionRepository.save(transaction);
		}
	}

	public List<OrdersResult> findAllOrders(String username) {
		List<OrdersResult> res = new ArrayList<>();
		
		//get all carts of the user;
		User user = userRepository.findByUsername(username);
		Iterable<Cart> carts = cartRepository.findByUser(user);
		
		for (Cart cart : carts) {
			OrdersResult or = new OrdersResult();
			or.setDelivered(cart.getIsPurchased());
			
			//get transaction info of that user.
			Transaction t = transactionRepository.findByCart(cart);
			if (t != null) {
				or.setPaymentInfo(t.getPaymentInfo());
				or.setTid(t.getId());
				or.setPurchasedOn(t.getPurchasedOn());
				res.add(or);
			}
		}
		return res;
	}

	public List<CartResult> getCartItems(Integer tid) {
		// Find all carts for the user.		
		Optional<Transaction> t = transactionRepository.findById(tid);
		Cart cart = null;
		if (t.isPresent()) {
			cart = t.get().getCart();
		}
		
		//Else create a new cart
		if (cart == null) {
			return new ArrayList<>();
		}
		
		List<Product> products = cart.getProducts();
		List<CartResult> res = new ArrayList<>();
		
		Map<Integer, Integer> map = new HashMap<>();
		for (Product p : products) {
			if (map.containsKey(p.getId())) {
				CartResult cr = res.get(map.get(p.getId()));
				cr.setQuantity(cr.getQuantity()+1);
				cr.setTotalPrice(cr.getPrice() * cr.getQuantity());
				continue;
			}
			
			map.put(p.getId(), res.size());
			CartResult cr = new CartResult();
			cr.setCid(cart.getId());
			cr.setPid(p.getId());
			cr.setPrice(p.getPrice());
			cr.setQuantity(1);
			cr.setTotalPrice(cr.getPrice());
			
			if (p.getType().equals("Track")) {
				Track track = trackRepository.findByProduct(p);
				if (track != null) {
					cr.setTid(track.getId());
					cr.setTitle(track.getTitle());
				}
			}else if (p.getType().equals("Album")) {
				Album album = albumRepository.findByProduct(p);
				if (album != null) {
					cr.setAid(album.getId());
					cr.setTitle(album.getTitle());
				}
			}
			
			res.add(cr);
			
		}
		return res;
	}

	public User changeStatus(Integer tid) {
		// Find all carts for the user.		
		System.out.println(tid + " Change Status");
		Optional<Transaction> t = transactionRepository.findById(tid);
		Cart cart = null;
		if (t.isPresent()) {
			cart = t.get().getCart();
		}
		
	
		cart.setIsPurchased(true);
		cartRepository.save(cart);
		return cart.getUser();
	}
}
