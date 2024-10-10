package com.naver.kiosk;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
    fw react, vue, next, nuxt
    react 통신요청 해서 -> spring data (json) 를 받아감
    mvc
    @controller view 꺼내준다
    @RestController = @Controller + @ResponseBody
 */
@RestController
public class TestController {
    // localhost:8080/java
//    만약에 10초 걸림
//    @RequestMapping(value = "/java", method = RequestMethod.GET)
    @GetMapping("/java")
    public String java(){
        return "java";
    }
//    get 메소드로 /name 으로 이름 출력하는 것 만들어보세요
//    API application programming interface(접점)
//    endpoint /name
    @GetMapping("/name")
    public String name(){
        return "name";
    }
}
