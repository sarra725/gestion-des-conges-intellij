package com.example.conges3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Conges3Application {

	public static void main(String[] args) {
		SpringApplication.run(Conges3Application.class, args);
	}

}