package com.devsuperior.movieflix.Dto;

import com.devsuperior.movieflix.entities.Role;

public class RoleDTO {

	private Long id;
	private String authority;
	
	public RoleDTO(Long id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}
	
	public RoleDTO(Role role) {
		this.id = role.getId();
		this.authority = role.getAuthority();
	}

	public Long getId() {
		return id;
	}

	public String getAuthority() {
		return authority;
	}	
}
