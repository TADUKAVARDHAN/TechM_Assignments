package com.example.exception;

public class PositionNotFoundException extends RuntimeException{
	public PositionNotFoundException(Integer id) {
		super("There is no position with ID: "+id);
	}
}
