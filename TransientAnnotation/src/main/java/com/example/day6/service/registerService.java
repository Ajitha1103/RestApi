package com.example.day6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.day6.model.registerModel;
import com.example.day6.repository.registerRepo;

@Service

public class registerService {
	@Autowired
	public registerRepo rrepo;
	
	//post the data
	public String saveRegistration(@RequestBody registerModel re)
	{
		rrepo.save(re);
		return "Data is saved";
	}
	
	//get the data
	public List<registerModel> getRegistration()
	{
		return rrepo.findAll();
	}

}
