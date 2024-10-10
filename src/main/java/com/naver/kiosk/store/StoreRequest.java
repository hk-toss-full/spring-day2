package com.naver.kiosk.store;

// 모든 field private final 이고 getter 가 있으면 변경가능
// recode classname(...field) 생성자
public record StoreRequest
        (String name, String address, short openTime, short closeTime) {

    public Store toStore(){
        return new Store(name, address, openTime, closeTime);
    }
}
