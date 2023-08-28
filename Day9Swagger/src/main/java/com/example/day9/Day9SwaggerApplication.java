package com.example.day9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(
		info =@Info(
				title = "College details",
				version = "1.1.0",
				description = "My sample Api",
				contact = @Contact(
						name = "Author Name",
						email = "Author Email"
						)
				)
		)

public class Day9SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day9SwaggerApplication.class, args);
	}

}
