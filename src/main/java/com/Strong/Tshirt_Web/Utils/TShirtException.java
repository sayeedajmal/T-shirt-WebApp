package com.Strong.Tshirt_Web.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TShirtException extends RuntimeException {

    public TShirtException(String message) {
        super(message);
    }

    public TShirtException() {
        super();
    }

    public TShirtException(String message, Throwable causationThrowable) {
        super(message, causationThrowable);
    }

    public TShirtException(Throwable causeI) {
        super(causeI);
    }

    @ExceptionHandler
    public ResponseEntity<TShirtErrorResponse> ErrorException(Exception exception) {
        TShirtErrorResponse response = new TShirtErrorResponse();
        response.setMessage(exception.getLocalizedMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
