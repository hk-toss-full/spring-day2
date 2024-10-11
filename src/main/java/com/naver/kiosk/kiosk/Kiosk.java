package com.naver.kiosk.kiosk;

import com.naver.kiosk.store.Store;

public class Kiosk {
    // 고유 값
    private final int id;
    // 가게의 키오스크 1-1 ,1-2, 1-3
    private final int kioskNumber;
    // 1 번  2번 3번
    private final Store store;
    // 고장
    private boolean active;
    public void crash(){
        this.active = false;
    }
    public int getId() {
        return id;
    }

    public int getKioskNumber() {
        return kioskNumber;
    }

    public Store getStore() {
        return store;
    }

    public boolean isActive() {
        return active;
    }

    public Kiosk(int kioskNumber, Store store) {        this.id = Utils.kioskCount++;
        this.kioskNumber = kioskNumber;
        this.store = store;
        this.active = true;
    }
}
