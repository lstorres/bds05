package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository repository;
	
	public User authenticated() {
		try {
			String email = SecurityContextHolder.getContext().getAuthentication().getName();
			User user = repository.findByEmail(email);
			return user;
		}catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
}
