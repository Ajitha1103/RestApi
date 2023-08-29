package com.example.day8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day8.model.studentModel;
import com.example.day8.service.studentService;

@RestController

public class studController {
	@Autowired
	public studentService sser;
	
	//post mapping
	@PostMapping("/saveStud")
	public String saveStudDetails(@RequestBody studentModel sn)
	{
		sser.saveStudent(sn);
		return "Details are stored in database";
	}
	
	//get mapping
	@GetMapping("/getStud")
	public List<studentModel> getStudDetails()
	{
		return sser.getStudent();
	}
	
	//put mapping
	@PutMapping("/updateStud")
	public studentModel updateStuddetails(@RequestBody studentModel se)
	{
		return sser.updateStudent(se);
	}

}
