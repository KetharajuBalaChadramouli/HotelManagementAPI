package com.hotel.utils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Errors {
    private String id;
    private String code;
    private String message;

    public Errors(String id, String code, String message) {
        this.id = id;
        this.code = code;
        this.message = message;
    }
}
