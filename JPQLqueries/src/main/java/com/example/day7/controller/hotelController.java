package com.example.day7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.day7.model.hotelModel;
import com.example.day7.service.hotelService;

@RestController

public class hotelController {
	@Autowired
	public hotelService hser;
	
	//post mapping
	@PostMapping("/saveHotel")
	public String saveHotelDetails(hotelModel ht)
	{
		hser.saveHotel(ht);
		return "Details are stored in database";
	}
	
	//get mapping
	@GetMapping("getHotel")
	public List<hotelModel> getHoteldetails()
	{ 
		return hser.getHotel();
	}
	
	//get all the rows
	@GetMapping("/getAllRows")
	public List<hotelModel> getAllHotelrows()
	{
		return hser.getAllByRows();
	}
	
	//get by name
	@GetMapping("/ByName/{name}")
	public List<hotelModel> getAllByname(@PathVariable("name") String name)
	{
		return hser.getAllByName(name);
	}
	
	//get the specific rows
	@GetMapping("/getSpec/{name}/{type}")
	public List<hotelModel> getAllBySpecrows(@PathVariable("name") String name,@PathVariable("type") String type)
	{
		return hser.getAllSpecRows(name, type);
	}
	
	//delete by id
	@DeleteMapping("/deleteId/{id}")
	public String deleteRow(@PathVariable("id") int id)
	{
		return hser.deleteById(id)+" deleted";
	}
	
	//update by id
	@PutMapping("/updateId/{name}/{id}")
	public String updateRow(@PathVariable("name") String name,@PathVariable("id") int id)
	{
		return hser.updateById(name, id)+" updated";
	}
	
	
	

}
