package com.example.day9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.day9.model.usersModel;
import com.example.day9.repository.userRepo;

@Service

public class userService {
	@Autowired
	public userRepo orepo;
	
	//post the data
	public String saveUser(@RequestBody usersModel us)
	{
		orepo.save(us);
		return "data is saved";
	}
	
	//get the data
	public List<usersModel> getUser()
	{
		return orepo.findAll();
	}
	

}
