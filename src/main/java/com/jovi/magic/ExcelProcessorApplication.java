package com.jovi.magic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ExcelProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelProcessorApplication.class, args);
	}
}
