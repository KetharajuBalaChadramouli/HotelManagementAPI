package com.hotel.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class HandleException {

    public static final String ERROR5001 = "5000";
    public static final String ERROR5001_DESC = "INTERNAL_SERVER_ERROR";

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponseEntity handleException(Exception ex, HttpServletRequest request, HttpServletResponse response){
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getErrorMessageException(ex));

    }

    @ExceptionHandler({ValidationException.class})
    @ResponseBody
    public ResponseEntity handleValidationException(Exception ex, HttpServletRequest request, HttpServletResponse response){
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        ValidationException exception =(ValidationException)ex;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getErrorMessage(exception));
    }

    private Error getErrorMessage(ValidationException ex){
        Error e= new Error();
        List<Errors> error = new ArrayList<>();
        error.add(new Errors("fsd244-kdk34-jfkf4-5444",ex.getErrorCode(),ex.getMessage()));
        e.setErrors(error);
        return e;
    }

    private Error getErrorMessageException(Exception ex){
        Error e= new Error();
        List<Errors> error = new ArrayList<>();
        error.add(new Errors("fsd244-kdk34-jfkf4-5444",null,ex.getMessage()));
        e.setErrors(error);
        return e;
    }

}
