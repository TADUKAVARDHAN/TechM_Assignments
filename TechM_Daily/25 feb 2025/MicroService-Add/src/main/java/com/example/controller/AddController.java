package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {
	@GetMapping("/add/num1/{n1}/num2/{n2}")
	public int add(@PathVariable("n1") int n1,@PathVariable("n2") int n2)
	{
		return n1+n2;
	}
}
