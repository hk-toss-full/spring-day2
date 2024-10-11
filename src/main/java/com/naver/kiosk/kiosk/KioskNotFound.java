package com.naver.kiosk.kiosk;

public class KioskNotFound extends RuntimeException {
    public KioskNotFound(int id) {
        super(id + " KIOSK NOT FOUND");
    }
}
