package com.naver.kiosk.store.service;

import com.naver.kiosk.kiosk.Kiosk;

import java.util.List;

public interface KioskService {
    List<Kiosk> getKiosksByStoreId(int storeId);
}
