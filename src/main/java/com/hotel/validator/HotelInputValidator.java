package com.hotel.validator;

import com.hotel.dto.HotelDetails;
import com.hotel.dto.HotelInput;
import com.hotel.utils.HotelConstants;
import com.hotel.utils.ValidationException;
import org.apache.commons.lang3.StringUtils;

public class HotelInputValidator {

    public static void validateInput(HotelInput hotelInput) {

        if (null == hotelInput || null == hotelInput.getHotelManageInput() || null == hotelInput.getHotelManageInput().getHotelManageData() || null == hotelInput.getHotelManageInput().getHotelManageData().getHotelManageAttributes() || null == hotelInput.getHotelManageInput().getHotelManageData().getHotelManageAttributes().getHotelDetails()) {
            throw new ValidationException("4001", HotelConstants.DESC_4001);
        }

        HotelDetails hotelDetails = hotelInput.getHotelManageInput().getHotelManageData().getHotelManageAttributes().getHotelDetails();
        if (!validateCustomerId(hotelInput.getCustomerId())) {
            throw new ValidationException("4002",HotelConstants.DESC_4002);
        }

        if(null == hotelDetails.getMobileNumber() || !hotelDetails.getMobileNumber().matches("^[7-9][0-9]{9}$")){
            throw new ValidationException("4003",HotelConstants.DESC_4003);
        }

        if(null == hotelDetails.getHotelName()){
            throw new ValidationException("4006",HotelConstants.DESC_4006);
        }
    }

    public static boolean validateCustomerId(Long accountNumber){
        if(!StringUtils.isNotBlank(String.valueOf(accountNumber))){
            return false;
        }

        if(!StringUtils.isNumeric(String.valueOf(accountNumber))){
            return false;
        }

        if(accountNumber.toString().length() >= 7 && accountNumber.toString().length() <=10){
            return true;
        }else{
            throw new ValidationException("4017",HotelConstants.DESC_4017);
        }


    }
}
