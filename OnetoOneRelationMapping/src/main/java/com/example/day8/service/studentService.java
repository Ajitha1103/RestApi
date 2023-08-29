package com.example.day8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.day8.model.studentModel;
import com.example.day8.repository.studentRepo;
@Service

public class studentService {
	@Autowired
	public studentRepo srepo;
	
	//post the data
	public String saveStudent(@RequestBody studentModel st)
	{
		srepo.save(st);
		return "data is saved";
	}
	
	//get the data
	public List<studentModel> getStudent()
	{
		return srepo.findAll();
	}
	
	//update the data
	public studentModel updateStudent(@RequestBody studentModel sm)
	{
		return srepo.saveAndFlush(sm);
	}
	

}
