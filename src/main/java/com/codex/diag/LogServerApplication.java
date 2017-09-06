package com.codex.diag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
public class LogServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogServerApplication.class, args);
	}
}
