package com.example.hotel.service.MicroHotelService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.service.MicroHotelService.entities.Hotel;
import com.example.hotel.service.MicroHotelService.services.HotelService;


@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
   private HotelService hotelService;
	
	@PostMapping
	 public ResponseEntity<Hotel> createUser(@RequestBody Hotel hotel){
		 Hotel createdHotel= hotelService.create(hotel);
		  return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
	  }
	
	@GetMapping("/{hotelId}")
	 public ResponseEntity<Hotel> createUser(@PathVariable String hotelId){
		 Hotel createdHotel= hotelService.get(hotelId);
		  return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
	  }
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
	}
	
	
}
