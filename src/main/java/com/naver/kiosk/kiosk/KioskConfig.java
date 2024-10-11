package com.naver.kiosk.kiosk;

import com.naver.kiosk.store.StoreService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KioskConfig {
    @Bean
    @ConditionalOnMissingBean
    public KioskService kioskService(StoreService storeService) {
        return new KioskServiceImpl(storeService);
    }
}
