package com.naver.kiosk.store.service;

import com.naver.kiosk.store.domain.Store;
import com.naver.kiosk.store.request.StoreRequest;
import com.naver.kiosk.store.response.StoreResponse;

import java.util.List;

public interface StoreService  {
    List<StoreResponse> getAllStores();
    Store getStoreById(int id);
    Store addStore(StoreRequest request);
    void deleteStore(int id);
    Store updateStore(int id, StoreRequest request);
}
