package com.naver.kiosk.store.domain;

import ch.qos.logback.core.util.StringUtil;
import com.naver.kiosk.kiosk.Kiosk;
import com.naver.kiosk.store.request.StoreRequest;
import com.naver.kiosk.store.util.Utils;

import java.util.ArrayList;
import java.util.List;

// 1. 가게
// name : 매머드커피
// address : 서울
// opentime: 7
// closetime: 21
// id : 1
// 2. 가게
// name : 깐부치킨
// address : 서울
// opentime : 11
// closetime : 1
// id : 2
// ...
public class Store {
    private final int id;
    private String name;
    private String address;
    private short openTime;
    private short closeTime;
    private boolean isDeleted;
    private List<Kiosk> kiosks;

    public List<Kiosk> getKiosks() {
        return kiosks;
    }

    public Store(String name, String address, short openTime, short closeTime) {
        this.id = Utils.storeCount++;
        this.name = name;
        this.address = address;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.isDeleted = false;
        this.kiosks = new ArrayList<>();
    }
    public void delete(){
        isDeleted = true;
    }
    public boolean isDeleted() {
        return isDeleted;
    }

    public Store update(StoreRequest request){
        if(!StringUtil.isNullOrEmpty(request.name()))
            this.name = request.name();
        if(!request.address().isEmpty())
            this.address = request.address();
        return this;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public short getOpenTime() {
        return openTime;
    }

    public short getCloseTime() {
        return closeTime;
    }

}
