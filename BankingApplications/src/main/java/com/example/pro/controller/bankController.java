package com.example.pro.controller;

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

import com.example.pro.model.bankModel;
import com.example.pro.service.bankService;

@RestController

public class bankController {
	@Autowired
	public bankService bser;
	
	//post mapping
	@PostMapping("/saveBank")
	public String saveBankdetails(@RequestBody bankModel ba)
	{
		bser.saveBank(ba);
		return "Data is Saved in Database";
	}
	
	//get mapping using id
	@GetMapping("/bank/{id}")
	public ResponseEntity<?> getBankAccountDetails(@PathVariable int id)
	{
		Optional<bankModel> bank=bser.getBankId(id);
		if(bank!=null)
		{
			return ResponseEntity.ok(bank);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bank Id not Available");
		}
	}
	
	
	//get mapping
	@GetMapping("/getBank") 
	public List<bankModel> getBankDetails()
	{
		return bser.getBank();
	}
	
	//put mapping with Id
	@PutMapping("/upbankInfo/{id}")
	public ResponseEntity<String> updateBankDetails(@PathVariable int id)
	{
		boolean updated = bser.updateBankInfo(id);
		if(updated)
		{
			return ResponseEntity.ok("Bank with Id "+id+" updated successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bank with Id "+id+" not found");
		}
	}
	
	//put mapping
	@PutMapping("/putBank")
	public bankModel putBankDetails(@RequestBody bankModel bn)
	{
		return bser.putBank(bn);
	}
	
	//delete if id is present
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteInfo(@PathVariable int id)
	{
		boolean deleted = bser.deleteBankInfo(id);
		if(deleted)
		{
			return ResponseEntity.ok("Bank with Id "+id+" deleted successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bank with Id "+id+" not found");
		}
	}
	
	//delete mapping using pathVariable
	@DeleteMapping("/deleteBank/{id}")
	public String deleteBankDetails(@PathVariable ("id") int bid)
	{
		bser.deleteBank(bid);
		return "Bank with Id "+bid+" is deleted";
	}
	
	//delete mapping using RequestParam
	@DeleteMapping("/myReqparam")
	public String removebankdetailas(@RequestParam ("id") int id)
	{
		bser.deleteBank(id);
		return "Bank with Id "+id+" is deleted";
	}

}
