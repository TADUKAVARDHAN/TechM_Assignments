package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.PersonNotFoundException;
import com.example.model.PersonInfo;
import com.example.repo.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {
	@Autowired
	private PersonRepository repo;
	@GetMapping("/details")
	public Flux<PersonInfo> getAll(){
		return repo.findAll();
	}
	@GetMapping("/details/{id}")
	public Mono<PersonInfo> getById(@PathVariable("id") final Integer id){
		return repo.findById(id)
				.switchIfEmpty(Mono.error(new PersonNotFoundException(id)));
	}
	@PostMapping("/details")
	public Mono add(@RequestBody final PersonInfo person) {
		return repo.save(person);
	}
	@PutMapping("/details/{id}")
	public Mono update(@PathVariable("id") final Integer id,@RequestBody final PersonInfo person) {
		return repo.findById(id)
				.flatMap(existingPerson->repo.save(person))
				.switchIfEmpty(Mono.error(new PersonNotFoundException(id)));
	}
	@DeleteMapping("/details/{id}")
	public Mono delete(@PathVariable("id") final Integer id) {
		return repo.findById(id)
				.flatMap(existingPerson->repo.delete(existingPerson)
						.then(Mono.just(ResponseEntity.noContent().build())))
				.switchIfEmpty(Mono.error(new PersonNotFoundException(id)));
	}
}
