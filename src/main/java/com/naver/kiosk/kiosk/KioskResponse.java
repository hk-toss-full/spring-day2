package com.naver.kiosk.kiosk;

import com.naver.kiosk.store.domain.Store;

public record KioskResponse(int id, int kioskNumber, Store store) {
    public static KioskResponse from(Kiosk kiosk) {
        return new KioskResponse(kiosk.getId(),
                kiosk.getKioskNumber(),
                kiosk.getStore());
    }
}
