package com.crioprogram.stayease.controller;

import com.crioprogram.stayease.dto.ResponseDTO;
import com.crioprogram.stayease.dto.RoomBookingDTO;
import com.crioprogram.stayease.service.IRoomBookingService;
import com.crioprogram.stayease.utility.JWTService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel-booking")
public class RoomBookingController {

    @Autowired
    private IRoomBookingService roomBookingService;

    @Autowired
    private JWTService jwtService;

    @PostMapping
    public ResponseEntity<ResponseDTO> roomBooking(@RequestBody @Valid RoomBookingDTO roomBookingDTO,
                                                   @RequestHeader("Authorization") String token){
        int userIdFromToken = jwtService.getUserIdFromToken(token);
        roomBookingDTO.setUserId(userIdFromToken);
        ResponseDTO responseDTO = roomBookingService.addRoomBooking(roomBookingDTO);
        return new ResponseEntity<>(responseDTO, responseDTO.getCode());
    }
}
