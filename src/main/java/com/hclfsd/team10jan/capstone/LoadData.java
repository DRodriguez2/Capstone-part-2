package com.hclfsd.team10jan.capstone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hclfsd.team10jan.capstone.entities.User;
import com.hclfsd.team10jan.capstone.repositories.UserRepository;

@Configuration
public class LoadData {
	  private static final Logger log = LoggerFactory.getLogger(LoadData.class);
	  
	  @Autowired
	  private  PasswordEncoder passwordEncoder;
	  
	  @Bean
	  CommandLineRunner initDatabase(UserRepository repository) {

	    return args -> {
	    	User user = repository.findByUsername("abc123");
	    	if (user == null) {
	  	      log.info("Preloading " + repository.save(new User("abc123", "abc123@gmail.com", passwordEncoder.encode("abc123"), 5186456585L, "ROLE_USER;ROLE_ADMIN")));
	    	}
	    };
	  }
}
