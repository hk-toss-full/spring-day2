package com.naver.kiosk.kiosk;

import com.naver.kiosk.store.Store;
import com.naver.kiosk.store.StoreResponse;

import java.util.List;
import java.util.Optional;

public interface GetStoreService {
    Optional<Store> getOptionalStoreById(int id);
}
