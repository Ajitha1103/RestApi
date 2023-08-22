package com.example.day5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.day5.model.studentModel;
import com.example.day5.repository.studentRepo;

@Service

public class studentService {
	@Autowired
	public studentRepo srepo;
	
	//post the data
	public String savestudent(studentModel s)
	{
		srepo.save(s);
		return "Data is stored in server";
	}
	//get by Id
	public Optional<studentModel> getStudId(int studId)
	{
		Optional<studentModel> stud = srepo.findById(studId);
		if(stud.isPresent())
		{
			return stud;
		}
		return null;		
	}
	
	//get the data
	public List<studentModel> getStudent()
	{
		return srepo.findAll();
	}
	
	//update if id is present
	public boolean updateStudInfo(int studId)
	{
		if(srepo.existsById(studId))
		{
			return true;
		}
		return false;
	}
	
	//put the data
	public studentModel putStudent(studentModel sm)
	{
		return srepo.saveAndFlush(sm);
	}
	
	//delete if id is present
	public boolean deleteStudInfo(int studId)
	{
		if(srepo.existsById(studId))
		{
			srepo.deleteById(studId);
			return true;
		}
		return false;
	}
	
	//delete the data
	public void deleteStudent(int studId)
	{
		System.out.println("deleted");
		srepo.deleteById(studId);
	}

}
