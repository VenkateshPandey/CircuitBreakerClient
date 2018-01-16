package com.cb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class CircuitBreakerClientApplication {

	@Autowired
	private BookService bookService;
	

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerClientApplication.class, args);
	}
	
	@RequestMapping(value="/mybooks")
	public String readingList() {
		return bookService.readingList();
	}
}
