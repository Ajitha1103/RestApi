package com.example.day9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day9.model.addressModel;
import com.example.day9.service.addressService;

@RestController

public class addressController {
	@Autowired
	public addressService aser;
	
	//post mapping
	@PostMapping("/saveAdd")
	public String saveAddressDetails(@RequestBody addressModel ad)
	{
		aser.saveAddress(ad);
		return "Data is stored in database";
	}
	
	//get mapping
	@GetMapping("/getAdd")
	public List<addressModel> getAddressDetails()
	{
		return aser.getAddress();
	}
	
	
}
