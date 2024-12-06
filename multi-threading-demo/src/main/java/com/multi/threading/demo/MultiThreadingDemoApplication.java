package com.multi.threading.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MultiThreadingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiThreadingDemoApplication.class, args);
	}

}
