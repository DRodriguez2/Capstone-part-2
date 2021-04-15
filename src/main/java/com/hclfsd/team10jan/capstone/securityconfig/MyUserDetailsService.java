package com.hclfsd.team10jan.capstone.securityconfig;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hclfsd.team10jan.capstone.entities.User;
import com.hclfsd.team10jan.capstone.services.UserService;


@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Username: " + username + " not FOUND!");
		}
		List<GrantedAuthority> authorities = Arrays.stream(user.getRoles().split(";")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
		return buildUserForAuthentication(user, authorities);
	}
	
	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}
	
}