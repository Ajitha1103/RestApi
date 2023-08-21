package com.example.demo.day1;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Exer1 {
	
	public String message;
	@RequestMapping("/display")
	
	public String welcome()
	{
		return "Welcome";
	}

}
