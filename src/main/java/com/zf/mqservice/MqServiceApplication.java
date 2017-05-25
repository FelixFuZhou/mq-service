package com.zf.mqservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.zf.mqservice"})
public class MqServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqServiceApplication.class, args);
	}
}
