package com.example.day9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.day9.model.collegeModel;
import com.example.day9.repository.collegeRepo;

@Service

public class collegeService {
	@Autowired
	public collegeRepo crepo;
	
	//post the data
	public String saveCollege(@RequestBody collegeModel cm)
	{
		crepo.save(cm);
		return "data is saved";
	}
	
	//get the data
	public List<collegeModel> getCollege()
	{
		return crepo.findAll();
	}
	
	//update the data
	public collegeModel updateCollege(@RequestBody collegeModel al)
	{
		return crepo.saveAndFlush(al);
	}
	
	//delete the data
	public void deleteById(int collegeId)
	{
		System.out.println("deleted");
		crepo.deleteById(collegeId);
	}
	

}
