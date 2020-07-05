package com.example.kristalai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.example.kristalai")
public class KristalAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KristalAiApplication.class, args);
	}

}
