package com.cb;

import java.net.URI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Configuration
@Service
public class BookService {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	};

	@HystrixCommand(fallbackMethod = "reliable")
	public String readingList() {
		URI uri = URI.create("http://localhost:8090/getmybooks");

		return getRestTemplate().getForObject(uri, String.class);
	}

	public String reliable() {
		return "Dhruv Comics";
	}

}
