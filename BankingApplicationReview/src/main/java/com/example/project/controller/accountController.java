package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Account;
import com.example.project.service.accountService;

@RestController

public class accountController {
	@Autowired
	public accountService aser;
	
	//post mapping
		@PostMapping("saveAccount")
		public String saveAccDetails(@RequestBody Account ac)
		{
			aser.saveAccount(ac);
			return "Account details are stored in database";
		}
	
	//get all rows
		@GetMapping("/getAllRows")
		public List<Account> getallrows()
		{
			return aser.getAllByRows();
		}
		
		//get specific rows
		@GetMapping("/getSpec/{a}/{id}")
		public List<Account> getallspecrows(@PathVariable("a") String a,@PathVariable("id") int id)
		{
			return aser.getSpecByRows(a, id);
		}
		
		//get by account holder name
		@GetMapping("/getByBal")
		public List<Account> getByAccountBal()
		{
			return aser.getByaccholder();
		}
		
		//delete mapping
		@DeleteMapping("/deleteId/{id}")
		public String deleteRowMap(@PathVariable("id") int id)
		{
			return aser.deleteById(id)+" deleted";
		}
		
		//update
		@PutMapping("updateId/{a}/{id}")
		public String updateRowMap(@PathVariable("n") String n,@PathVariable("id") int id)
		{
			return aser.updateById(n, id)+" updated";
		}
		
		
		//Sorting by Asc
				@GetMapping("/sortaccAsc")
				public List<Account> sortByAsc(@RequestParam ("name") String name)
				{
					return aser.sortAsc(name);
				}
				
				//Sorting by Des
				@GetMapping("/sortaccDes")
				public List<Account> sortByDes(@RequestParam ("name") String name)
				{
					return aser.sortDes(name);
				}
				
				//pagination
				@GetMapping("paginationacc/{num}/{size}")
				public List<Account> paginationDetails(@PathVariable("num") int num, @PathVariable("size") int size)
				{
					return aser.pagination(num, size);
				}
				
				//pagination and sorting
				@GetMapping("paginationacc/{num}/{size}/{name}")
				public List<Account> paginationSortingDetails(@PathVariable("num") int num, @PathVariable("size") int size,@PathVariable("name") String name)
				{
					return aser.paginationSorting(num, size, name);
				}

}
