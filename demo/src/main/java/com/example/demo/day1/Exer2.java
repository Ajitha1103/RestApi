package com.example.demo.day1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exer2 {
	 @Value("Ajitha")
	public String studentName;
	
	@RequestMapping("/display1")
	public String getname()
	{
		return "Welcome "+studentName+" !";
	}

}
