package com.example.day9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day9.model.usersModel;
import com.example.day9.service.userService;

@RestController
public class userController {
	@Autowired
	public userService user;
	
	//post mapping
	@PostMapping("/saveUser")
	public String saveUserdetails(@RequestBody usersModel um)
	{
		user.saveUser(um);
		return "Data is stored in database";
	}
	
	//get mapping
	@GetMapping("/getUser")
	public List<usersModel> getUserdetails()
	{
		return user.getUser();
	}

}
