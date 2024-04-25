package com.example.hotel.service.MicroHotelService.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.service.MicroHotelService.entities.Hotel;
import com.example.hotel.service.MicroHotelService.exceptions.ResourceNotFoundException;
import com.example.hotel.service.MicroHotelService.repositories.HotelRepository;
import com.example.hotel.service.MicroHotelService.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		String randomHotelIdString = UUID.randomUUID().toString();
		hotel.setId(randomHotelIdString);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String hotelId) {
		
		return hotelRepository.findById(hotelId).orElseThrow(
				()-> new ResourceNotFoundException("hotel with given Id is not found on server!! :"+hotelId)
				);
				
	}

}
