package com.example.hotel.service.MicroHotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.service.MicroHotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
