package com.naver.kiosk.store;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
restful api
리소스(data)를 꺼내 주자
endpoint /stores
method  GET R
        POST C
        PUT(POST), PATCH(POST)  U body o
        DELETE(GET) D body x
전체 스토어를 가져온다.( /stores ) (GET)
스토어에 추가한다. (/stores) (POST)
스토어 안에 id=1 번인거를 가져와라. (/stores/1) (GET)
스토어 안에 이름이 커피가 들어간 친구들 뽑아와라. (/stores?name=커피&opentime=10) (GET)
1번 스토어 이름을 커피로 바꾸고 싶다.
(/stores/1, {name="커피", "ㄹㅇㄴ","ㅇㄴㅁ"}) (PUT)
setName("커피")
나머지 것은 두고 슬쩍 수정 PATCH (패치노트)
[1][2][3]<-[new3]
전에 있던놈을 갈아 치운다 PUT
스토어 1번을 지운다 (stores/1) (DELETE)

정리
1. URL 복수형 만 사용해라 (/store x) -> /stores
2. 명사만 사용해라 (/stores/create x) -> /stores POST
3. 소문자로 작성해라 (/storesCreate) -> (/store_create)
4. 언더바(_) 말고 하이픈(-)으로 작성해라 (/store_create) -> (/store-create)

성공했다. 실패했다. 하긴 했는데 별 일 없었다.
http 통신

status code
100 =< > 200 socket
200 =< > 300 http 통신 (성공)
300 =< > 400 html 을 사용 할때 (Found, Redirect)
400 =< > 500 클라이언트 실수 (404 not found, 401 권한 없음)
500 =< > 600 서버측 실수 (500 internal server error)
 */

@RestController
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }
    @GetMapping("/{store-id}")
    public Store getStoreById(
            @PathVariable(value = "store-id") int id
    ) {
        return Utils.stores
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .orElseThrow(() -> new StoreNotFoundException(id));

//        if (first.isEmpty()) throw new StoreNotFoundException(id);
//        return first.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Store saveStore(
            @RequestBody StoreRequest request
    ) {
        Store store = request.toStore();
        Utils.stores.add(store);
        return store;
    }
    @DeleteMapping("/{store-id}")
    public void deleteStore(@PathVariable(value = "store-id") int id){
        Store storeById = getStoreById(id);
        Utils.stores.remove(storeById);
    }
    @PutMapping("/{store-id}")
    public Store updateStore(
            @PathVariable(value = "store-id") int id,
            @RequestBody StoreRequest request
    ){
        return getStoreById(id).update(request);
    }
}
