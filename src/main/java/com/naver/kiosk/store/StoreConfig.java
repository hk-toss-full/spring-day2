package com.naver.kiosk.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class StoreConfig {
    @Bean
    public StoreService storeService(){
        return new Store2ServiceImpl() ;
    }
}
