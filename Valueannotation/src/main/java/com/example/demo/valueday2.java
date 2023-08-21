package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class valueday2 {

	@Value("Ajitha")
	public String name;
	@Value("005")
	public int regNum;
	@RequestMapping("/")
	
	public String display1()
	{
		return "My name is "+name+" Register number is "+regNum;
	}

}
