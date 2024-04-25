package com.example.hotel.service.MicroHotelService.services;

import java.util.List;

import com.example.hotel.service.MicroHotelService.entities.Hotel;

public interface HotelService {
   Hotel create(Hotel hotel);
   List<Hotel> getAll();
   Hotel get(String id);
}
