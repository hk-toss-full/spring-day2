package com.naver.kiosk.store;

import java.util.List;

public interface StoreService {
    List<StoreResponse> getAllStores();
    Store getStoreById(int id);
    Store addStore(StoreRequest request);
    void deleteStore(int id);
    Store updateStore(int id, StoreRequest request);
}
