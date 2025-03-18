package com.example.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.model.PositionInfo;

public interface PositionRepository extends ReactiveMongoRepository<PositionInfo,Integer>{

}
