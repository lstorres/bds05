package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.Dto.UserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;

import javassist.NotFoundException;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public List<UserDTO> findAll() {
		return repository.findAll().stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
	}

	public UserDTO getUserDTO(Long id) throws NotFoundException {
		User user = repository.findById(id).orElseThrow(() -> new NotFoundException("User not founded"));
		return new UserDTO(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if (user == null) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("User found: " + username);
		return user;
	}
}
