package com.example.day7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day7.model.hotelModel;
import com.example.day7.repository.hotelRepo;

@Service

public class hotelService {
	@Autowired
	public hotelRepo hrepo;
	
	//post the data
	public String saveHotel(hotelModel hm)
	{
		hrepo.save(hm);
		return "Data is Saved";
	}
	
	//get the data
	public List<hotelModel> getHotel()
	{
		return hrepo.findAll();
	}
	
	//get all the data
	public List<hotelModel> getAllByRows()
	{
		return hrepo.getAllRows();
	}
	
	//get by name
	public List<hotelModel> getAllByName(String name)
	{
		return hrepo.getByName(name);
	}
	
	//get the specific rows
	public List<hotelModel> getAllSpecRows(String name,String type)
	{
		return hrepo.getSpecRows(name, type);
	}
	
	//delete the data
	public int deleteById(int id)
	{
		return hrepo.deleteId(id);
	}
	
	//update the data
	public Integer updateById(String name,int id)
	{
		return hrepo.updateId(name, id);
	}
	

}
