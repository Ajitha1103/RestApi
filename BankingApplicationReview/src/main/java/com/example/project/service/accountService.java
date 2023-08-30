package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.project.model.Account;
import com.example.project.repository.accountRepo;

@Service

public class accountService {
	@Autowired
	public accountRepo arepo;
	
	//post the data
	public String saveAccount(@RequestBody Account a)
	{
		arepo.save(a);
		return "data is saved";
	}
	
	//get all data
		public List<Account> getAllByRows()
		{
			return arepo.getAllRows();
		}
		
		//get the specific rows
		public List<Account> getSpecByRows(String n,int id)
		{
			return arepo.getSpecRows(n, id);
		}
		
		//get by account holder name
		public List<Account> getByaccholder()
		{
			return arepo.getByAccname();
		}
		
		//delete the data
		public int deleteById(int id)
		{
			return arepo.deleteId(id);
		}
		
		//update the data
		public Integer updateById(String a,int id)
		{
			return arepo.updateId(a, id);
		}
		
		
		//sorting (ascending)
				public List<Account> sortAsc(String name)
				{
					return arepo.findAll(Sort.by(name));
				}
				
				//sorting (descending)
				public List<Account> sortDes(String name)
				{
					return arepo.findAll(Sort.by(name).descending());
				}
				
				//pagination
				public List<Account> pagination(int pageNum,int pageSize)
				{
					Page<Account> acc=arepo.findAll(PageRequest.of(pageNum, pageSize));
					return acc.getContent();
				}
				
				//pagination and sorting
				public List<Account> paginationSorting(int pageNum,int pageSize,String name)
				{
					Page<Account> acc=arepo.findAll(PageRequest.of(pageNum, pageSize,Sort.by(name)));
					return acc.getContent();
				}

}
