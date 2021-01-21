package com.hotel.service;

import com.hotel.dto.HotelInput;
import com.hotel.dto.HotelResponseOutput;
import org.springframework.http.ResponseEntity;

public interface HotelService {

    /**
     * @param hotelInput
     * @return
     */
    public ResponseEntity<HotelResponseOutput> bookHotelRoom(HotelInput hotelInput);
}
