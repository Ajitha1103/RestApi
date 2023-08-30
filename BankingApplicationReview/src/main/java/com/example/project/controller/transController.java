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

import com.example.project.model.Transaction;
import com.example.project.service.transactionService;

@RestController

public class transController {
	@Autowired
	public transactionService tser;
	
	//post mapping
		@PostMapping("saveTrans")
		public String saveTransDetails(@RequestBody Transaction ts)
		{
			tser.saveTrans(ts);
			return "Transaction details are stored in database";
		}
	
	//get all rows
		@GetMapping("/getAlltransRows")
		public List<Transaction> getallrowsMap()
		{
			return tser.getAllByRows();
		}
		
		//get specific rows
		@GetMapping("/getSpectrans/{name}/{id}")
		public List<Transaction> getallbyspecrows(@PathVariable("name") String name)
		{
			return tser.getSpecByRows(name);
		}
		
		//delete mapping
		@DeleteMapping("/deletetransId/{id}")
		public String deleteRow(@PathVariable("id") int id)
		{
			return tser.deleteById(id)+" deleted";
		}
		
		//update
		@PutMapping("updatetransId/{am}/{id}")
		public String updateRow(@PathVariable("am") double am,@PathVariable("id") int id)
		{
			return tser.updateById(am, id)+" updated";
		}
		
		
		//Sorting by Asc
				@GetMapping("/sorttransAsc")
				public List<Transaction> sortByAsc(@RequestParam ("name") String name)
				{
					return tser.sortAsc(name);
				}
				
				//Sorting by Des
				@GetMapping("/sorttransDes")
				public List<Transaction> sortByDes(@RequestParam ("name") String name)
				{
					return tser.sortDes(name);
				}
				
				//pagination
				@GetMapping("paginationtrans/{num}/{size}")
				public List<Transaction> paginationDetails(@PathVariable("num") int num, @PathVariable("size") int size)
				{
					return tser.pagination(num, size);
				}
				
				//pagination and sorting
				@GetMapping("paginationtrans/{num}/{size}/{name}")
				public List<Transaction> paginationSortingDetails(@PathVariable("num") int num, @PathVariable("size") int size,@PathVariable("name") String name)
				{
					return tser.paginationSorting(num, size, name);
				}

}
