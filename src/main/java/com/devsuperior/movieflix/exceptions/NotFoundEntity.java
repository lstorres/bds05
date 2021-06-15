package com.devsuperior.movieflix.exceptions;

public class NotFoundEntity extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NotFoundEntity(String message){
		super(message);
	}

}
