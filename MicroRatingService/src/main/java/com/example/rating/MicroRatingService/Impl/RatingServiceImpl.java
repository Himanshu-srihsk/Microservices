package com.example.rating.MicroRatingService.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rating.MicroRatingService.entities.Rating;
import com.example.rating.MicroRatingService.repository.RatingRepo;
import com.example.rating.MicroRatingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
  private RatingRepo ratingRepo;

	@Override
	public Rating create(Rating rating) {
		String randomUserIdString = UUID.randomUUID().toString();
		rating.setRatingId(randomUserIdString);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}
	
}
