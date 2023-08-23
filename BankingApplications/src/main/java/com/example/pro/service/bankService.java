package com.example.pro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;

import com.example.pro.model.bankModel;
import com.example.pro.repository.bankRepo;

@Service

public class bankService {
	@Autowired
	public bankRepo brepo;
	
	//post the data
	public String saveBank(bankModel bk)
	{
		brepo.save(bk);
		return "Data is saved in server";
	}
	
	//get the data by Id
	public Optional<bankModel> getBankId(int bankId)
	{
		Optional<bankModel> bank=brepo.findById(bankId);
		if(bank.isPresent())
		{
			return bank;
		}
		return null;
	}
	
	//get the data
	public List<bankModel> getBank()
	{
		return brepo.findAll();
	}
	
	//update if id is present
	public boolean updateBankInfo(int bankId)
	{
		if(brepo.existsById(bankId))
		{
			return true;
		}
		return false;
	}
	
	
	//put the data
	public bankModel putBank(bankModel bm)
	{
		return brepo.saveAndFlush(bm);
	}
	
	//delete if id is present
	public boolean deleteBankInfo(int bankId)
	{
		if(brepo.existsById(bankId))
		{
			brepo.deleteById(bankId);
			return true;
		}
		return false;
	}
	//delete the data
	public void deleteBank(int bankId)
	{
		System.out.println("Bank Id Deleted");
		brepo.deleteById(bankId);
	}

}
