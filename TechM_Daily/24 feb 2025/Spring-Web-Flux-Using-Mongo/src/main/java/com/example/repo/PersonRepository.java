package com.example.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.model.PersonInfo;

public interface PersonRepository extends ReactiveMongoRepository<PersonInfo,Integer>{

}
