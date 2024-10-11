package com.naver.kiosk.kiosk;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class KioskExceptionController {

    @ExceptionHandler(KioskNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void kioskNotFoundHandler(KioskNotFound e) {
        System.out.println(e.getMessage());
    }

}
