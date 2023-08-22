package com.example.day5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day5.model.studentModel;
import com.example.day5.service.studentService;

@RestController

public class studentController {
	@Autowired
	studentService sser;
	
	//post mapping
	@PostMapping("/saveStudent")
	public String saveStudentDetails(@RequestBody studentModel st)
	{
		sser.savestudent(st);
		return "data is saved";
	}
	
	//get mapping using id
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getStudentId(@PathVariable int id)
	{
		Optional<studentModel> stud = sser.getStudId (id);
		if(stud!=null)
		{
			return ResponseEntity.ok(stud);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Id not Available");
		}
	}
	
	//get mapping
	@GetMapping("/getStudent")
	public List<studentModel> getStudentDetails()
	{
		return sser.getStudent();
	}
	
	@PutMapping("/upStudInfo/{id}")
	public ResponseEntity<String> updateStudDetails(@PathVariable int id)
	{
		boolean updated = sser.updateStudInfo(id);
		if(updated)
		{
			return ResponseEntity.ok("Student with Id "+id+" updated successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with Id "+id+" not found");
		}
	}
	
	//put mapping (updating)
	@PutMapping("/putStudent")
	public studentModel updateStudentDetails(@RequestBody studentModel sp)
	{
		return sser.putStudent(sp);
	}
	
	@DeleteMapping("/deleteInfo/{id}")
	public ResponseEntity<String> deleteInfo(@PathVariable int id)
	{
		boolean deleted = sser.deleteStudInfo(id);
		if(deleted)
		{
			return ResponseEntity.ok("Student with Id "+id+" deleted successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id "+id+" not found");
		}
	}
	
	//delete mapping with pathVariable
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudentDetails(@PathVariable ("id") int hid )
	{
		sser.deleteStudent(hid);
		return "Student with Id "+hid+" is deleted";
	}
	
	//delete mapping with requestParam
	@DeleteMapping("/byReqParam")
	public String removeStudentDetails(@RequestParam ("id") int id)
	{
		sser.deleteStudent(id);
		return "Student with Id "+id+" is deleted";
	}

}
