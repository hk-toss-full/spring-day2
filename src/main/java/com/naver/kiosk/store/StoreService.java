package com.naver.kiosk.store;

import com.naver.kiosk.kiosk.GetStoreService;

import java.util.List;

public interface StoreService extends GetStoreService {
    List<StoreResponse> getAllStores();
    Store getStoreById(int id);
    Store addStore(StoreRequest request);
    void deleteStore(int id);
    Store updateStore(int id, StoreRequest request);
}
