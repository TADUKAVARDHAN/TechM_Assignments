package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.exception.TweetNotFoundException;
import com.example.model.TweetInfo;
import com.example.payload.ErrorResponse;
import com.example.repo.TweetRepository;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TweetController {
    @Autowired 
    private TweetRepository repo;
    @GetMapping("/tweets")
    public Flux<TweetInfo> getAllTweets() {
        return repo.findAll();
    }
    @GetMapping("/tweets/{id}")
    public Mono<ResponseEntity<TweetInfo>> getTweetById(@PathVariable(value = "id") String tweetId) {
        return repo.findById(tweetId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @PostMapping("/tweets")
    public Mono<ResponseEntity<TweetInfo>> createTweet(@Valid @RequestBody TweetInfo tweet) {
        return repo.save(tweet)
                .map(savedTweet -> ResponseEntity.status(HttpStatus.CREATED).body(savedTweet))
                .onErrorResume(DuplicateKeyException.class, ex -> 
                    Mono.just(ResponseEntity.status(HttpStatus.CONFLICT)
                            .body(null)) // Handle duplicate key errors
                );
    }
    @PutMapping("/tweets/{id}")
    public Mono<ResponseEntity<TweetInfo>> updateTweet(@PathVariable(value = "id") String tweetId,
                                                       @Valid @RequestBody TweetInfo tweet) {
        return repo.findById(tweetId)
                .flatMap(existingTweet -> {
                    existingTweet.setText(tweet.getText());
                    return repo.save(existingTweet);
                })
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/tweets/{id}")
    public Mono<ResponseEntity<Object>> deleteTweet(@PathVariable(value = "id") String tweetId) {
        return repo.findById(tweetId)
                .flatMap(existingTweet -> repo.delete(existingTweet)
                        .then(Mono.just(ResponseEntity.noContent().build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @GetMapping(value = "/stream/tweets", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TweetInfo> streamAllTweets() {
        return repo.findAll(); 
    }
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity handleDuplicateKeyException(DuplicateKeyException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("A Tweet with the same text already exists"));
    }

    @ExceptionHandler(TweetNotFoundException.class)
    public ResponseEntity handleTweetNotFoundException(TweetNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }
}
