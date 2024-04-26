package com.example.user.service.MicroUserService.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.user.service.MicroUserService.entities.Hotel;

@FeignClient(name="HOTELSERVICE")
public interface HotelService {
	@GetMapping("/hotels/{hotelId}")
   public Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
