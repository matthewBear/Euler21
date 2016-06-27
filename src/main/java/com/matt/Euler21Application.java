package com.matt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Euler21Application {

	public static void main(String[] args) {
		SpringApplication.run(Euler21Application.class, args);
	}
}
