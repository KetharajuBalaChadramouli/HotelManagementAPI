package com.hotel.service.impl;

import com.hotel.dto.*;
import com.hotel.repository.HotelDAO;
import com.hotel.service.HotelService;
import com.hotel.utils.HotelConstants;
import com.hotel.utils.ValidationException;
import com.hotel.validator.HotelInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDAO hotelDAO;
    /**
     * @param hotelInput
     * @return ResponseEntity
     */
    @Override
    public ResponseEntity<HotelResponseOutput> bookHotelRoom(HotelInput hotelInput) {

        HotelInputValidator.validateInput(hotelInput);
        HotelDetails hotelDetails = null;
        HotelResponseOutput hotelResponseOutput = new HotelResponseOutput();
        HotelResponseData responseData = new HotelResponseData();
        HotelResponseAttribute responseAttribute = new HotelResponseAttribute();

        if(null != hotelInput.getHotelManageInput())
            hotelDetails = hotelInput.getHotelManageInput().getHotelManageData().getHotelManageAttributes().getHotelDetails();

        List<Hotel> hotel = hotelDAO.findAll();
        HotelDetails finalHotelDetails = hotelDetails;
         for(Hotel hotels: hotel) {
            if (hotels.getHotelName().equalsIgnoreCase(finalHotelDetails.getHotelName())) {
                if (hotels.getRoomAval().equalsIgnoreCase("YES")) {
                    int possiblebooks = finalHotelDetails.getBonusPoints() / hotels.getCost();
                    if (finalHotelDetails.getRoom() <= possiblebooks) {
                        responseAttribute.setStatus("Success..!! " + finalHotelDetails.getRoom() + " rooms booked");
                        responseData.setHotelResponseAttribute(responseAttribute);
                        hotelResponseOutput.setData(responseData);
                        return new ResponseEntity<HotelResponseOutput>(hotelResponseOutput, new HttpHeaders(), HttpStatus.OK);
                    } else {
                        responseAttribute.setStatus("Pending for Approvals..!! ");
                        responseData.setHotelResponseAttribute(responseAttribute);
                        hotelResponseOutput.setData(responseData);
                        return new ResponseEntity<HotelResponseOutput>(hotelResponseOutput, new HttpHeaders(), HttpStatus.OK);
                    }
                } else {
                    responseAttribute.setStatus(HotelConstants.DESC_4004);
                    responseData.setHotelResponseAttribute(responseAttribute);
                    hotelResponseOutput.setData(responseData);
                    return new ResponseEntity<HotelResponseOutput>(hotelResponseOutput, new HttpHeaders(), HttpStatus.BAD_REQUEST);
                }
            }


        }
        if(null == responseAttribute.getStatus())
        throw new ValidationException("4005",HotelConstants.DESC_4005);

        return null;
    }
}
