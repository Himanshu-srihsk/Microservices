package com.example.rating.MicroRatingService.services;

import java.util.List;

import com.example.rating.MicroRatingService.entities.Rating;

public interface RatingService {
  Rating create(Rating rating);
  List<Rating> getRatings();
  List<Rating> getRatingByUserId(String userId);
  List<Rating> getRatingByHotelId(String hotelId);
}
