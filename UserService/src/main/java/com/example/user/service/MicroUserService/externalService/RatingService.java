package com.example.user.service.MicroUserService.externalService;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.user.service.MicroUserService.entities.Rating;


@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {
	@PostMapping("/ratings")
  public ResponseEntity<Rating> createRating(Rating rating);
	@PutMapping("/ratings/{ratingId}")
  public ResponseEntity<Rating> updateRating(@PathVariable String ratingId,Rating rating);
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);
}
