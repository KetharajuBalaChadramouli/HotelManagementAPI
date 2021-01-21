package com.hotel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HotelResponseData {

    @JsonProperty("attributes")
    private HotelResponseAttribute hotelResponseAttribute;

    public HotelResponseAttribute getHotelResponseAttribute() {
        return hotelResponseAttribute;
    }

    public void setHotelResponseAttribute(HotelResponseAttribute hotelResponseAttribute) {
        this.hotelResponseAttribute = hotelResponseAttribute;
    }
}
