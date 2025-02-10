package com.crioprogram.stayease.controller;

import com.crioprogram.stayease.dto.HotelDTO;
import com.crioprogram.stayease.dto.ResponseDTO;
import com.crioprogram.stayease.service.IHotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotels/")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @PostMapping("add-hotel")
    public ResponseEntity<ResponseDTO> addHotel(@RequestBody @Valid HotelDTO hotelDTO){
        ResponseDTO hotel = hotelService.addHotel(hotelDTO);
        return new ResponseEntity<>(hotel, hotel.getCode());
    }

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAllHotels(){
        ResponseDTO hotel = hotelService.getAllHotel();
        return new ResponseEntity<>(hotel, hotel.getCode());
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<ResponseDTO> getHotelById(@PathVariable int hotelId){
        ResponseDTO hotel = hotelService.getHotelById(hotelId);
        return new ResponseEntity<>(hotel, hotel.getCode());
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<ResponseDTO> updateHotelDetails(@PathVariable int hotelId, @RequestBody @Valid HotelDTO hotelDTO){
        ResponseDTO hotel = hotelService.updateHotelDetail(hotelId, hotelDTO);
        return new ResponseEntity<>(hotel, hotel.getCode());
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<ResponseDTO> removeHotel(@PathVariable int hotelId){
        ResponseDTO hotel = hotelService.removeHotel(hotelId);
        return new ResponseEntity<>(hotel, hotel.getCode());
    }
}
