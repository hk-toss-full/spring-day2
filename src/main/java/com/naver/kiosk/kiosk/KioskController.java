package com.naver.kiosk.kiosk;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kiosks")
public class KioskController {
    private final KioskService kioskService;

    public KioskController(KioskService kioskService) {
        this.kioskService = kioskService;
    }
    @GetMapping
    public List<KioskResponse> getAllKiosks(){
        return kioskService.getAllKiosks();
    }
    @GetMapping("/{id}")
    public KioskResponse getKioskById(@PathVariable int id){
        return kioskService.getKioskById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteKioskById(@PathVariable int id){
        kioskService.deleteKiosk(id);
    }
    @PostMapping
    public KioskResponse createKiosk(@RequestBody KioskRequest kioskRequest){
        return kioskService.addKiosk(kioskRequest);
    }
}
