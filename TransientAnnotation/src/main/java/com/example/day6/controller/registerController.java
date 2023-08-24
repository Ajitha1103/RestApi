package com.example.day6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day6.model.registerModel;
import com.example.day6.service.registerService;
@RestController

public class registerController {
	@Autowired
	public registerService rser;
	
	//post mapping
	@PostMapping("/saveReg")
	public String saveRegDetails(@RequestBody registerModel rg)
	{
		rser.saveRegistration(rg);
		return "Registration Details saved in database";
	}
	
	//get mapping
	@GetMapping("/getReg")
	public List<registerModel> getRegDetails()
	{
		return rser.getRegistration();
	}

}
