package com.example.demo.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class valueExample {
	
	@Value(value="${name}")
	public String studname;
	@Value(value="${age:19}")
	public int studage;
	@GetMapping("/")
	 
	public String display()
	{
		return "Name is "+studname+" Age is "+studage;
	}
}
