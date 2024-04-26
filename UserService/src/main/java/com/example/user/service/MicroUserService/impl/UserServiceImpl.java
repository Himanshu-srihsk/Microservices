package com.example.user.service.MicroUserService.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.service.MicroUserService.Repository.UserRepo;
import com.example.user.service.MicroUserService.entities.Hotel;
import com.example.user.service.MicroUserService.entities.Rating;
import com.example.user.service.MicroUserService.entities.User;
import com.example.user.service.MicroUserService.exceptions.ResourceNotFoundException;
import com.example.user.service.MicroUserService.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepo userRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		//generating unique userID
		String randomUserIdString = UUID.randomUUID().toString();
		user.setUserId(randomUserIdString);
		return this.userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return this.userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		
		User user= this.userRepo.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("User with given Id os not found on server!! :"+userId)
				);
		//fetch rating of above user from RATING SERVICE
		//http://localhost:8085/ratings/users/4fd7f4a5-31cf-4ef2-aa3b-4ed64cd0b564
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		
		//logger.info("{}",ratingsOfUser);
		
//		user.setRatings(ratingsOfUser);
		List<Rating> ratings= Arrays.stream(ratingsOfUser).toList();
		//http://localhost:8084/hotels/98bfffdc-4456-44a7-abca-a6a77d8bb237
		
		//get hotel info from ratings
		List<Rating> ratingList = ratings.stream().map((rating)->{
		ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
		Hotel hotel= forEntity.getBody();
		logger.info("response status code:{}",forEntity.getStatusCode());
		rating.setHotel(hotel);
		return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		
		return user;
	}
 
}
