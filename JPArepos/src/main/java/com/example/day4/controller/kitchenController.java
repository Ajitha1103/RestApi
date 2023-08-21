package com.example.day4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4.model.kitchenOrg;
import com.example.day4.service.kitchenService;

@RestController

public class kitchenController {
	
	@Autowired
	kitchenService kser;
	@PostMapping("/saveDetails")
	public kitchenOrg saveKitchenOrgDetails(@RequestBody kitchenOrg ko)
	{
		return kser.saveDetails(ko);
	}
	@GetMapping("/foodDetails")
	public List<kitchenOrg> getKitchenDetails()
	{
		return kser.getDetails();
		
	}
}
