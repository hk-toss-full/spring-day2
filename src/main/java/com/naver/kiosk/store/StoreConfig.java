package com.naver.kiosk.store;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StoreConfig {
    @Bean
    @ConditionalOnMissingBean
    public StoreService storeService(){
        return new StoreServiceImpl();
    }

}
