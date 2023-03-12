package com.Contact;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@OpenAPIDefinition(info = @Info(title = "Assignment API", version = "1.0"))
public class ContactManagementSystemAssignment {
	public static void main(String[] args) {
		SpringApplication.run(ContactManagementSystemAssignment.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
