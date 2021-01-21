package com.hotel.controller;

import com.hotel.dto.HotelInput;
import com.hotel.dto.HotelManageInput;
import com.hotel.dto.HotelResponseOutput;
import com.hotel.service.HotelService;
import com.hotel.utils.HandleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelController extends HandleException{

    @Autowired
    private HotelService hotelService;

    /**
     * @param customerId
     * @param hotelManageInput
     * @return
     */
    @PostMapping("/v1/hotelbooking/{customerId}")
public ResponseEntity<HotelResponseOutput> bookHotelRoom(@PathVariable("customerId") Long customerId,
                                                         @RequestBody(required = true) HotelManageInput hotelManageInput,
                                                         @RequestHeader(value = "Correlation-ID",required = true) String correlationId,
                                                         @RequestHeader(value = "Authorization",required = false) String authorization){
        HotelInput hotelInput = new HotelInput();
        if(null != customerId)
            hotelInput.setCustomerId(customerId);

        if(null != hotelManageInput)
            hotelInput.setHotelManageInput(hotelManageInput);

        ResponseEntity<HotelResponseOutput> response = hotelService.bookHotelRoom(hotelInput);
        return response;
    }
}
