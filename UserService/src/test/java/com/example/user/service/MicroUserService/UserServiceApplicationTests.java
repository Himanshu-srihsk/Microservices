package com.example.user.service.MicroUserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.user.service.MicroUserService.entities.Rating;
import com.example.user.service.MicroUserService.externalService.RatingService;

@SpringBootTest
class UserServiceApplicationTests {
	@Autowired
	private RatingService ratingService;
    
	@Test
	void contextLoads() {
	}
	
	@Test
	void createRating() {
		 Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("this is created using feign client").build();
		 ResponseEntity<Rating> savedRating = ratingService.createRating(rating);
		 
		 System.out.println("new rating created");
	}

}
