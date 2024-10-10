package com.naver.kiosk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KioskApplication {

	public static void main(String[] args) {
		SpringApplication.run(KioskApplication.class, args);
	}

}
/*
	http > method
	GET body x 요청 방법 : url 치고 들어감
	localhost:8080/java
	POST body o <form> url x
 */