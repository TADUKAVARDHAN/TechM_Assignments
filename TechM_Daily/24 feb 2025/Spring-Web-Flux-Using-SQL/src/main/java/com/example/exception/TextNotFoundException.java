package com.example.exception;

public class TextNotFoundException extends RuntimeException{
	public TextNotFoundException(Integer id) {
		super("There is no tweet found with ID: "+id);
	}
}
