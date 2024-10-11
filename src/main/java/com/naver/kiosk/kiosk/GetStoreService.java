package com.naver.kiosk.kiosk;

import com.naver.kiosk.store.domain.Store;

import java.util.Optional;

public interface GetStoreService {
    Optional<Store> getOptionalStoreById(int id);
}
