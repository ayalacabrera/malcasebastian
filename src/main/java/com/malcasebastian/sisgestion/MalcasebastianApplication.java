package com.malcasebastian.sisgestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MalcasebastianApplication {

	public static void main(String[] args) {
		SpringApplication.run(MalcasebastianApplication.class, args);
	}

}
