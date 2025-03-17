package com.example.demo.repository;

import com.example.demo.model.MovieReview;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieReviewRepository extends MongoRepository<MovieReview, String> {
}
