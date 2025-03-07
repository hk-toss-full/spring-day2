package com.naver.kiosk.store.service;

import com.naver.kiosk.kiosk.GetStoreService;
import com.naver.kiosk.kiosk.Kiosk;
import com.naver.kiosk.store.domain.Store;
import com.naver.kiosk.store.exception.StoreNotFoundException;
import com.naver.kiosk.store.request.StoreRequest;
import com.naver.kiosk.store.response.StoreResponse;
import com.naver.kiosk.store.util.Utils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// controller 유저와 개발자의 소통 공간
// service 개발자의 생각 공간
// repository 개발자와 data 와의 소통 공간
@Service
public class StoreServiceImpl
        implements StoreService, GetStoreService, KioskService {
    public List<StoreResponse> getAllStores(){
        List<StoreResponse> list = Utils.stores
                .stream()
                .map(StoreResponse::from)
                .toList();
        return list;
    }
    public Store getStoreById(int id){
        return getOptionalStoreById(id)
                .orElseThrow(() -> new StoreNotFoundException(id));
    }
    public Store addStore(StoreRequest request){
        Store store = request.toStore();
        Utils.stores.add(store);
        return store;
    }
    public void deleteStore(int id){
        Store storeById = getStoreById(id);
        storeById.delete();
    }

    public Store updateStore(int id, StoreRequest request){
        return getStoreById(id).update(request);
    }

    @Override
    public Optional<Store> getOptionalStoreById(int id) {
        return Utils.stores
                .stream()
                .filter(el -> el.getId() == id && !el.isDeleted())
                .findFirst();
    }

    @Override
    public List<Kiosk> getKiosksByStoreId(int storeId) {

        return List.of();
    }
}
