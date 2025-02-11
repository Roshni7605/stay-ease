package com.crioprogram.stayease.service;

import com.crioprogram.stayease.dto.ResponseDTO;
import com.crioprogram.stayease.dto.RoomBookingDTO;
import com.crioprogram.stayease.model.Hotel;
import com.crioprogram.stayease.model.RoomBooking;
import com.crioprogram.stayease.repository.HotelRepository;
import com.crioprogram.stayease.repository.RoomBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RoomBookingServiceImpl implements IRoomBookingService{

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomBookingRepository roomBookingRepository;


    @Override
    public ResponseDTO addRoomBooking(RoomBookingDTO roomBookingDTO) {
        try{
            Hotel hotel = hotelRepository.findByHotelName(roomBookingDTO.getHotelName());
            if(hotel.getAvailableRooms() == 0) new ResponseDTO(HttpStatus.CONFLICT, null,
                    "Rooms are not available for booking");
            RoomBooking confirmed = new RoomBooking(roomBookingDTO.getUserId(), hotel, roomBookingDTO.getNumberOfGuests(),
                    "CONFIRMED", roomBookingDTO.getCheckInDate(), roomBookingDTO.getCheckOutDate());
            hotel.setAvailableRooms(hotel.getAvailableRooms()-1);
            hotel.setBookings(confirmed);
            hotelRepository.save(hotel);
            RoomBooking roomBooking = roomBookingRepository.save(confirmed);
            return new ResponseDTO(HttpStatus.CREATED, roomBooking, "Hotel Room Booked Successfully.");
        }
        catch (Exception exception){
            return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, exception.getLocalizedMessage(),
                    "Something went wrong");
        }
    }

    @Override
    public ResponseDTO cancelRoomBooking(int bookingId) {
        return null;
    }
}
