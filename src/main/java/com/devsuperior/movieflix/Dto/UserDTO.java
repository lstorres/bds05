package com.devsuperior.movieflix.Dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.devsuperior.movieflix.entities.User;

public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private String password;
	private Set<RoleDTO> rolesDTO = new HashSet<>();
	
	public UserDTO(Long id, String name, String email, String password, Set<RoleDTO> rolesDTO) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.rolesDTO = rolesDTO;
	}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.rolesDTO = user.getRoles().stream().map(role -> new RoleDTO(role)).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Set<RoleDTO> getRolesDTO() {
		return rolesDTO;
	}
	
}
