package com.crioprogram.stayease.dto;

import java.time.LocalDate;

public class RoomBookingDTO {
    private String hotelName;
    private int userId;
    private int numberOfGuests;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public RoomBookingDTO(String hotelName, int userId, int numberOfGuests, LocalDate checkInDate, LocalDate checkOutDate) {
        this.hotelName = hotelName;
        this.userId = userId;
        this.numberOfGuests = numberOfGuests;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
