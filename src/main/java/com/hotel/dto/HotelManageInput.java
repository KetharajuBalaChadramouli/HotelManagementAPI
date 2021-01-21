package com.hotel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HotelManageInput {
    @JsonProperty("data")
    private HotelManageData hotelManageData;

    public HotelManageData getHotelManageData() {
        return hotelManageData;
    }

    public void setHotelManageData(HotelManageData hotelManageData) {
        this.hotelManageData = hotelManageData;
    }
}
