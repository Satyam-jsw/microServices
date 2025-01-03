package com.hotel.services.services;

import com.hotel.services.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create

    Hotel create(Hotel hotel);


    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);

}