package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.PositionNotFoundException;
import com.example.model.PositionInfo;
import com.example.repo.PositionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PositionController {
	@Autowired
	private PositionRepository repo;
	@GetMapping("/position")
	public Flux<PositionInfo> getAll(){
		return repo.findAll();
	}
	@GetMapping("/position/{id}")
	public Mono getById(@PathVariable("id") final Integer id) {
		return repo.findById(id)
				.switchIfEmpty(Mono.error(new PositionNotFoundException(id)));
	}
	@PostMapping("/position")
	public Mono add(@RequestBody PositionInfo p) {
		return repo.save(p);
	}
	@PutMapping("/position/{id}")
	public Mono update(@PathVariable("id") Integer id,@RequestBody PositionInfo p) {
		return repo.findById(id)
				.flatMap(existingPosition->repo.save(p))
				.switchIfEmpty(Mono.error(new PositionNotFoundException(id)));
	}
	@DeleteMapping("/position/{id}")
	public Mono delete(@PathVariable("id") Integer id) {
		return repo.deleteById(id)
				.switchIfEmpty(Mono.error(new PositionNotFoundException(id)));
	}
}
