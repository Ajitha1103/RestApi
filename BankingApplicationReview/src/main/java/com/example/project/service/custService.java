package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.project.model.Customer;
import com.example.project.repository.customerRepo;

@Service

public class custService {
	@Autowired
	public customerRepo crepo;
	
	//post the data
	public String saveCustomer(@RequestBody Customer c)
	{
		crepo.save(c);
		return "data is saved";
	}
	
	//get all data
	public List<Customer> getAllByRows()
	{
		return crepo.getAllRows();
	}
	
	//get the specific rows
	public List<Customer> getSpecByRows(String name,int id)
	{
		return crepo.getSpecRows(name, id);
	}
	
	//delete the data
	public int deleteById(int id)
	{
		return crepo.deleteId(id);
	}
	
	//update the data
	public Integer updateById(String name,int id)
	{
		return crepo.updateId(name, id);
	}
	
	
	//sorting (ascending)
		public List<Customer> sortAsc(String name)
		{
			return crepo.findAll(Sort.by(name));
		}
		
		//sorting (descending)
		public List<Customer> sortDes(String name)
		{
			return crepo.findAll(Sort.by(name).descending());
		}
		
		//pagination
		public List<Customer> pagination(int pageNum,int pageSize)
		{
			Page<Customer> cus=crepo.findAll(PageRequest.of(pageNum, pageSize));
			return cus.getContent();
		}
		
		//pagination and sorting
		public List<Customer> paginationSorting(int pageNum,int pageSize,String name)
		{
			Page<Customer> cus=crepo.findAll(PageRequest.of(pageNum, pageSize,Sort.by(name)));
			return cus.getContent();
		}
	
		
		//delete if id is present
		public boolean deleteCustInfo(int custId)
		{
			if(crepo.existsById((long) custId))
			{
				crepo.deleteById((long) custId);
				return true;
			}
			return false;
		}
		
}
