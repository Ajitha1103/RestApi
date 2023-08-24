package com.example.day6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day6.model.employModel;
import com.example.day6.service.employService;

@RestController

public class employController {
	@Autowired
	public employService eser;
	
	//post mapping
	@PostMapping("/saveEmp")
	public String saveEmpDetails(@RequestBody employModel ep)
	{
		eser.saveEmployee(ep);
		return "Employee details are saved in database";
	}
	
	//Sorting by Asc
	@GetMapping("/sortAsc")
	public List<employModel> sortByAsc(@RequestParam ("name") String name)
	{
		return eser.sortAsc(name);
	}
	
	//Sorting by Des
	@GetMapping("/sortDes")
	public List<employModel> sortByDes(@RequestParam ("name") String name)
	{
		return eser.sortDes(name);
	}
	
	//pagination
	@GetMapping("pagination/{num}/{size}")
	public List<employModel> paginationDetails(@PathVariable("num") int num, @PathVariable("size") int size)
	{
		return eser.pagination(num, size);
	}
	
	//pagination and sorting
	@GetMapping("pagination/{num}/{size}/{name}")
	public List<employModel> paginationSortingDetails(@PathVariable("num") int num, @PathVariable("size") int size,@PathVariable("name") String name)
	{
		return eser.paginationSorting(num, size, name);
	}

}
