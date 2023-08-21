package com.example.demo.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.json.jsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class ValueannotationApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(ValueannotationApplication.class, args);
		jsonIgnore obj = new jsonIgnore("Ajitha",123,19);
		ObjectMapper map = new ObjectMapper();
		String str = map.writeValueAsString(obj);
		System.out.println(str);
	}

}
