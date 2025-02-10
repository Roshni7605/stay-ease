package com.crioprogram.stayease.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer hotelId;

    @Column(unique = true, nullable = false)
    private String hotelName;
    @Column(nullable = false)
    private String location;
    private String description;
    private int availableRooms;

    public Hotel(){

    }

    public Hotel(String hotelName, String location, String description, int availableRooms) {
        this.hotelName = hotelName;
        this.location = location;
        this.description = description;
        this.availableRooms = availableRooms;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }
}
