package com.hotel.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_HOTELS")
@Data
public class Hotel {

    @Id
    private Long id;

    @Column(name="hotel_name")
    private String hotelName;

    @Column(name="location")
    private String locaiton;

    @Column(name="mob_num")
    private String mobileNumber;

    @Column(name = "room_avail")
    private String roomAval;

    @Column(name = "cost")
    private Integer cost;



    public String getHotelName() {
        return hotelName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocaiton() {
        return locaiton;
    }

    public void setLocaiton(String locaiton) {
        this.locaiton = locaiton;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRoomAval() {
        return roomAval;
    }

    public void setRoomAval(String roomAval) {
        this.roomAval = roomAval;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
