package com.hotel.dto;

import lombok.Data;

@Data
public class HotelInput {

    private Long customerId;
    private HotelManageInput hotelManageInput;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public HotelManageInput getHotelManageInput() {
        return hotelManageInput;
    }

    public void setHotelManageInput(HotelManageInput hotelManageInput) {
        this.hotelManageInput = hotelManageInput;
    }
}

