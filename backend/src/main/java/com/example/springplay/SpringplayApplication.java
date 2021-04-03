package com.example.springplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringplayApplication.class, args);
	}

}
