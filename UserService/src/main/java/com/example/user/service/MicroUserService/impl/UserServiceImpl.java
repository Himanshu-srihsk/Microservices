package com.example.user.service.MicroUserService.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.service.MicroUserService.Repository.UserRepo;
import com.example.user.service.MicroUserService.entities.User;
import com.example.user.service.MicroUserService.exceptions.ResourceNotFoundException;
import com.example.user.service.MicroUserService.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepo userRepo;
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
		
		return this.userRepo.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("User with given Id os not found on server!! :"+userId)
				);
	}
 
}
