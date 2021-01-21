package com.hotel.dto;

import lombok.Data;

@Data
public class HotelResponseAttribute {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
