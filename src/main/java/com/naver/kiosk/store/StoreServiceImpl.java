package com.naver.kiosk.store;

import org.springframework.stereotype.Service;

import java.util.List;

// controller 유저와 개발자의 소통 공간
// service 개발자의 생각 공간
// repository 개발자와 data 와의 소통 공간
@Service
public class StoreServiceImpl implements StoreService {
    public List<Store> getAllStores(){
        System.out.println(1);
        return Utils.stores;
    }
    public Store getStoreById(int id){
        return Utils.stores
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .orElseThrow(() -> new StoreNotFoundException(id));
    }
    public Store addStore(StoreRequest request){
        Store store = request.toStore();
        Utils.stores.add(store);
        return store;
    }
    public void deleteStore(int id){
        Store storeById = getStoreById(id);
        Utils.stores.remove(storeById);
    }

    public Store updateStore(int id, StoreRequest request
    ){
        return getStoreById(id).update(request);
    }
}
