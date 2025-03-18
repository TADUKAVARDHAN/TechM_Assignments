package com.example.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.EmpDetails;

public interface Repository extends MongoRepository<EmpDetails,Integer>{
}
