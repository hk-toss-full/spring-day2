package com.naver.kiosk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;

@SpringBootApplication
public class KioskApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(KioskApplication.class, args);

	}

}
/*
	http > method
	GET body x 요청 방법 : url 치고 들어감
	localhost:8080/java
	POST body o <form> url x
 */