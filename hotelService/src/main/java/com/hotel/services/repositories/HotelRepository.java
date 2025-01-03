package com.hotel.services.repositories;

import com.hotel.services.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {


}
