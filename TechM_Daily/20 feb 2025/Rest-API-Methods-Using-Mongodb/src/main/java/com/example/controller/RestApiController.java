package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.Repository;
import com.example.model.EmpDetails;

@RestController
@RequestMapping("/api")
public class RestApiController {
	@Autowired
	Repository repo;
	@GetMapping("/read")
	public List<EmpDetails> get(){
		return repo.findAll();
	}
	@GetMapping("/readAny/{id}")
	public EmpDetails getAny(@PathVariable Integer id) {
		Optional<EmpDetails> y = repo.findById(id);
		if(y.isPresent()) {
			return y.get();
		}
		else {
			throw new RuntimeException("Employee not found with the id "+id);
		}
	}
	@PostMapping("/write")
	public String write(@RequestBody EmpDetails e) {
		repo.save(e);
		return "message: Data is stored";
	}
	@PutMapping("/update")
	public String update(@RequestBody EmpDetails e) {
		repo.save(e);
		return "message: Data is updated";
	}
	@DeleteMapping("/delete/{id}")
	public String deleteAny(@PathVariable Integer id) {
		Optional<EmpDetails> y = repo.findById(id);
		if(y.isPresent()) {
			repo.deleteById(id);
			return "message: Data with the id "+id+" is deleted";
		}
		else {
			return "There is no data with the id "+id; 
		}
	}
	@DeleteMapping("delete")
	public String deleteAll() {
		repo.deleteAll();
		return "All the data in the database is deleted";
	}
}
