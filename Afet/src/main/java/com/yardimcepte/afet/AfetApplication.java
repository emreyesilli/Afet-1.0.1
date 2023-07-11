package com.yardimcepte.afet;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AfetApplication {

	public static void main(String[] args) {
		SpringApplication.run(AfetApplication.class, args);
	}

	@Bean
	public ModelMapper getModelModelMapper() {
		return new ModelMapper();
	}

}
