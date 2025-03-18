package com.example.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
@RestController
public class RestAPIController {
	@GetMapping("/show")
	public String get() {
		return "Get method is called";
	}
	@PutMapping("/show")
	public String put() {
		return "Put method is called";
	}
	@PostMapping("/show")
	public String post() {
		return "Post method is called";
	}
	@DeleteMapping("/show")
	public String delete() {
		return "Delete method is called";
	}
	@PatchMapping("/show")
	public String patch() {
		return "Patch method is called";
	}
}
