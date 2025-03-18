package com.example.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.model.TweetInfo;

public interface TweetRepository extends ReactiveMongoRepository<TweetInfo,String>{

}
