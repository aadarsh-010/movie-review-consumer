package com.example.demo.service;

import com.example.demo.config.StringConverter;
import com.example.demo.model.MovieReview;
import com.example.demo.repository.MovieReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MovieReviewConsumerService {
    private final MovieReviewRepository repository;

    public MovieReviewConsumerService(MovieReviewRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(
            topics = "movie-reviews",
            groupId = "movie-review-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeReview(String  review) {
        String jsonString = StringConverter.cleanJsonString(StringConverter.removeSlashes(review));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MovieReview movieReview = objectMapper.readValue(jsonString, MovieReview.class);
            System.out.println(movieReview);
            repository.save(movieReview);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
