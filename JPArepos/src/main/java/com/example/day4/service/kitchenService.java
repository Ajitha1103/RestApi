package com.example.day4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day4.model.kitchenOrg;
import com.example.day4.repository.KitchenRepo;

@Service

public class kitchenService {
	@Autowired
	public KitchenRepo krepo;
	
	//posting the data
	public kitchenOrg saveDetails(kitchenOrg k)
	{
		return krepo.save(k);
	}
	
	//get the data
	public List<kitchenOrg> getDetails()
	{
		return krepo.findAll();
	}
	

}
