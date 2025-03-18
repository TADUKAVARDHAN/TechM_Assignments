package com.example.exception;

public class PersonNotFoundException extends RuntimeException{
	public PersonNotFoundException(Integer id) {
	super("There is no person found with ID: "+id);
}}
