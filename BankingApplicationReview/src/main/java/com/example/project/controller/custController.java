package com.example.project.controller;

import java.util.List;

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

import com.example.project.model.Customer;
import com.example.project.service.custService;

@RestController

public class custController {
	@Autowired
	public custService cser;
	
	//post mapping
	@PostMapping("saveCustomer")
	public String saveCustDetails(@RequestBody Customer cs)
	{
		cser.saveCustomer(cs);
		return "Customer details are stored in database";
	}
	
	//get all rows
	@GetMapping("/getAllcustRows")
	public List<Customer> getallrowsMap()
	{
		return cser.getAllByRows();
	}
	
	//get specific rows
	@GetMapping("/getSpeccust/{name}/{id}")
	public List<Customer> getallbyspecrows(@PathVariable("name") String name,@PathVariable("id") int id)
	{
		return cser.getSpecByRows(name, id);
	}
	
	//delete mapping
	@DeleteMapping("/deletecustId/{id}")
	public String deleteRow(@PathVariable("id") int id)
	{
		return cser.deleteById(id)+id+" deleted";
	}
	
	//update
	@PutMapping("updatecustId/{name}/{id}")
	public String updateRow(@PathVariable("name") String name,@PathVariable("id") int id)
	{
		return cser.updateById(name, id)+" updated";
	}
	
	
	//Sorting by Asc
		@GetMapping("/sortAsc")
		public List<Customer> sortByAsc(@RequestParam ("name") String name)
		{
			return cser.sortAsc(name);
		}
		
		//Sorting by Des
		@GetMapping("/sortDes")
		public List<Customer> sortByDes(@RequestParam ("name") String name)
		{
			return cser.sortDes(name);
		}
		
		//pagination
		@GetMapping("pagination/{num}/{size}")
		public List<Customer> paginationDetails(@PathVariable("num") int num, @PathVariable("size") int size)
		{
			return cser.pagination(num, size);
		}
		
		//pagination and sorting
		@GetMapping("pagination/{num}/{size}/{name}")
		public List<Customer> paginationSortingDetails(@PathVariable("num") int num, @PathVariable("size") int size,@PathVariable("name") String name)
		{
			return cser.paginationSorting(num, size, name);
		}
		
		
		@DeleteMapping("/deleteInfo/{id}")
		public ResponseEntity<String> deleteInfo(@PathVariable int id)
		{
			boolean deleted = cser.deleteCustInfo(id);
			if(deleted)
			{
				return ResponseEntity.ok("Customer with Id "+id+" deleted successfully");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with id "+id+" not found");
			}
		}

}
