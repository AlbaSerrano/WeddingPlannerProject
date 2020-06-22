package com.plannerofrings.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootWeddingPlannerApplication implements CommandLineRunner {

	// inject the @Bean to encrypt the passwords
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWeddingPlannerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Base password for the user bride
		String bridePassword = "bride12345";

		// Base password for the user groom
		String groomPassword = "groom12345";

		// Base password for the user guest
		String guestsPassword = "guest12345";

		// encrypt the passwords of the three users
		passwordEncoder.encode(bridePassword);

		passwordEncoder.encode(groomPassword);

		passwordEncoder.encode(guestsPassword);
		

	}
	

}
