package com.hotel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HotelManageData {

    @JsonProperty("attributes")
    private HotelManageAttribute hotelManageAttributes;

    public HotelManageAttribute getHotelManageAttributes() {
        return hotelManageAttributes;
    }

    public void setHotelManageAttributes(HotelManageAttribute hotelManageAttributes) {
        this.hotelManageAttributes = hotelManageAttributes;
    }
}
