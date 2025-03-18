package com.example.exception;

public class TweetNotFoundException extends RuntimeException {
	public TweetNotFoundException(String id) {
		super("Tweet not found with the ID: "+id);
	}
}
