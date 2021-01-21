package com.hotel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HotelResponseOutput {

    @JsonProperty("data")
    private HotelResponseData data;

    public HotelResponseData getData() {
        return data;
    }

    public void setData(HotelResponseData data) {
        this.data = data;
    }
}
