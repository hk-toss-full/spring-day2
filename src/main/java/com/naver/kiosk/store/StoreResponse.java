package com.naver.kiosk.store;

public record StoreResponse
        (int id, String name, String address,
         short openTime, short closeTime) {
    public static StoreResponse from(Store store){
        return new StoreResponse(
                store.getId(), store.getName(), store.getAddress(),
                store.getOpenTime(), store.getCloseTime());
    }
}
