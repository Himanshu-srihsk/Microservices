package com.example.user.service.MicroUserService.services;

import java.util.List;

import com.example.user.service.MicroUserService.entities.User;

public interface UserService {
   User saveUser(User user);
   List<User> getAllUser();
   User getUser(String userId);
   
   //TODO: delete
   //TODO: update
}
