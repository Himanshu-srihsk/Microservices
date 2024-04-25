package com.example.user.service.MicroUserService.exceptions;

import lombok.experimental.SuperBuilder;

public class ResourceNotFoundException extends RuntimeException{
   public ResourceNotFoundException() {
	   super("Resource not found on server !!");
   }
   public ResourceNotFoundException(String message) {
	   super(message);
   }
}
