package com.hotel.dto;

import lombok.Data;

@Data
public class HotelManageAttribute {

    private HotelDetails hotelDetails;

    public HotelDetails getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(HotelDetails hotelDetails) {
        this.hotelDetails = hotelDetails;
    }
}
