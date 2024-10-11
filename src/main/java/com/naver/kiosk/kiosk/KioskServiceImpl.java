package com.naver.kiosk.kiosk;

import com.naver.kiosk.store.domain.Store;
import com.naver.kiosk.store.exception.StoreNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KioskServiceImpl implements KioskService {
    private final GetStoreService storeService;
    public KioskServiceImpl(GetStoreService storeService) {
        this.storeService = storeService;
    }

    @Override
    public List<KioskResponse> getAllKiosks() {
        return Utils.kiosks.stream()
                .map(KioskResponse::from)
                .toList();
    }

    @Override
    public KioskResponse getKioskById(int id) {
        return getOptionalKioskById(id)
                .map(KioskResponse::from)
                .orElseThrow(() -> new KioskNotFound(id));
    }

    public Optional<Kiosk> getOptionalKioskById(int id){
        return Utils.kiosks
                .stream()
                .filter(kiosk -> kiosk.isActive()&& kiosk.getId()==id)
                .findFirst();
    }

    @Override
    public KioskResponse addKiosk(KioskRequest request) {
        Store store = storeService
                .getOptionalStoreById(request.storeId())
                .orElseThrow(() -> new StoreNotFoundException(request.storeId()));
        Kiosk kiosk = new Kiosk(request.kioskNumber(), store);
        Utils.kiosks.add(kiosk);
        kiosk.getStore().getKiosks().add(kiosk);
        return KioskResponse.from(kiosk);
    }



    @Override
    public void deleteKiosk(int id) {
        getOptionalKioskById(id)
                .orElseThrow(() -> new KioskNotFound(id))
                .crash();
    }
}
