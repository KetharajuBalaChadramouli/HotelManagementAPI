package com.hotel.utils;

public class ValidationException extends ApiException{

    public ValidationException(String errorCode, String errorMessage){
        super(errorCode, errorMessage);
    }
}
