package com.example.user.service.MicroUserService.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.service.MicroUserService.entities.User;
import com.example.user.service.MicroUserService.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")

public class UserController {
	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user){
	  User createdUser= userService.saveUser(user);
	  return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
  }
	int retryCount=1;
	
	@GetMapping("/{userId}")
	//@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	//@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
	
	@RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		logger.info("Get Single user Handler: user Controller");
		logger.info("Retry Count: {}", retryCount);
		//retryCount++;
		
		User user= userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
		//logger.info("Falback is executed because service is down!!", ex.getMessage());
		 ex.printStackTrace();
		 
	    User user=	
	    		User.builder()
	    		.email("dummy@gmail.com")
	    		.name("Dummy")
	    		.about("this is dummy creation as some services down !!")
	    		.userId("112332")
	    		.build();
		
		
		
	        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUsers = userService.getAllUser();
		return ResponseEntity.ok(allUsers);
	}
}
