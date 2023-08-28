package com.example.day9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.day9.model.collegeModel;
import com.example.day9.service.collegeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController

public class collegeController {
	@Autowired
	public collegeService cser;
	
	//post mapping
	@PostMapping("/saveColl")
	@Tag(name="Insert here",description = "save all college details")
	public String saveCollDetails(@RequestBody collegeModel cd)
	{
		cser.saveCollege(cd);
		return "College details are stored in database";
	}
	
	//get mapping
	@GetMapping("/getColl")
	@Tag(name="Display here",description = "get all college details")
	public List<collegeModel> getColldetails()
	{
		return cser.getCollege();
	}
	
	//update mapping
	@PutMapping("/updateColl")
	@Tag(name="Update here",description = "modify all college details")
	public collegeModel updateCollDetails(@RequestBody collegeModel cl)
	{
		return cser.updateCollege(cl);
	}
	
	//delete by Id
	@DeleteMapping("/delById/{id}")
	@Tag(name="Delete here",description = "delete the college details with Id")
	public String deleteCollDetails(@PathVariable ("id") int cid )
	{
		cser.deleteById(cid);
		return "college with Id "+cid+" is deleted";
	}

}
