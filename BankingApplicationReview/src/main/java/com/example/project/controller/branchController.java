package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Branch;
import com.example.project.service.branchService;
@RestController

public class branchController {
	@Autowired
	public branchService bser;
	
	//post mapping
	@PostMapping("/saveBranch")
	public String saveBranchDetails(@RequestBody Branch br)
	{
		bser.saveBranch(br);
		return "branch details are stored in database";
	}
	
	//get mapping
	@GetMapping("/getBranch")
	public List<Branch> getBranchDetails()
	{
		return bser.getBranch();
	}
	
	//Sorting by Asc
	@GetMapping("/sortbranAsc")
	public List<Branch> sortByAsc(@RequestParam ("name") String name)
	{
		return bser.sortAsc(name);
	}
	
	//Sorting by Des
	@GetMapping("/sortbranDes")
	public List<Branch> sortByDes(@RequestParam ("name") String name)
	{
		return bser.sortDes(name);
	}
	
	//pagination
	@GetMapping("paginationbran/{num}/{size}")
	public List<Branch> paginationDetails(@PathVariable("num") int num, @PathVariable("size") int size)
	{
		return bser.pagination(num, size);
	}
	
	//pagination and sorting
	@GetMapping("paginationbran/{num}/{size}/{name}")
	public List<Branch> paginationSortingDetails(@PathVariable("num") int num, @PathVariable("size") int size,@PathVariable("name") String name)
	{
		return bser.paginationSorting(num, size, name);
	}
	

}
