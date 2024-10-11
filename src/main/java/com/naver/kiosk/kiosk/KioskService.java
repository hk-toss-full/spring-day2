package com.naver.kiosk.kiosk;



import java.util.List;

public interface KioskService {
    List<KioskResponse> getAllKiosks();
    KioskResponse getKioskById(int id);
    KioskResponse addKiosk(KioskRequest request);

    void deleteKiosk(int id);
}
