package com.example.demo.day1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Exer3 {
	@Value("Black")
	public String favColor;
	
	@RequestMapping("/display2")
	public String getMyFav()
	{
		return "My favorite color is "+favColor;
	}

}
