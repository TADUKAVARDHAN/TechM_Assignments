package com.example.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.example.model.TweetInfo;
public interface TweetRepository extends ReactiveCrudRepository<TweetInfo,Integer>{
	
}
