package com.example.user.service.MicroUserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.service.MicroUserService.entities.User;

public interface UserRepo extends JpaRepository<User, String>{

}
