package com.example.day9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.day9.model.addressModel;
import com.example.day9.repository.addressRepo;

@Service

public class addressService {
	@Autowired
	public addressRepo arepo;
	
	//post the data
	public String saveAddress(@RequestBody addressModel am)
	{
		arepo.save(am);
		return "data is saved";
	}

	//get the data
	public List<addressModel> getAddress()
	{
		return arepo.findAll();
	}
	
	
}
