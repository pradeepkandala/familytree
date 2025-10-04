package com.ism.familytree;

import com.ism.familytree.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FamilytreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilytreeApplication.class, args);
	}
}
