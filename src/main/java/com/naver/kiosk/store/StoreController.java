package com.naver.kiosk.store;

import java.util.List;

public class StoreController {
    public List<Store> getAllStores(){
        return null;
    }

    public static void main(String[] args) {
        Store store =
                new Store("매머드", "서울"
                        , (short) 7, (short) 21);
        Store store2 =
                new Store( "깐부", "서울"
                        , (short) 11, (short) 1);
        Utils.stores.add(store);
        Utils.stores.add(store2);
        List<Store> allStores = new StoreController().getAllStores();
        for(int i =0; i< allStores.size(); i++){
            if(!Utils.stores.get(i).equals(allStores.get(i)))
                throw new RuntimeException();
        }
    }
}
