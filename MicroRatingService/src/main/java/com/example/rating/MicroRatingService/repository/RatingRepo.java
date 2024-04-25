package com.example.rating.MicroRatingService.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.rating.MicroRatingService.entities.Rating;

public interface RatingRepo extends MongoRepository<Rating, String>{
   List<Rating> findByUserId(String userId);
   List<Rating> findByHotelId(String hotelId);
}
