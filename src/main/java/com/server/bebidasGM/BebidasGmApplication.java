package com.server.bebidasGM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BebidasGmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BebidasGmApplication.class, args);
		//System.out.println("pass: "+new BCryptPasswordEncoder().encode("admin"));
	}

}
