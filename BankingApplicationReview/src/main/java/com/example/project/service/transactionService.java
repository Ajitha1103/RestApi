package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.project.model.Transaction;
import com.example.project.repository.transactionRepo;

@Service

public class transactionService {
	@Autowired
	 public transactionRepo trepo;
	
	//post the data
		public String saveTrans(@RequestBody Transaction t)
		{
			trepo.save(t);
			return "data is saved";
		}
	
	//get all data
		public List<Transaction> getAllByRows()
		{
			return trepo.getAllRows();
		}
		
		//get the specific rows
		public List<Transaction> getSpecByRows(String name)
		{
			return trepo.getSpecRows(name);
		}
		
		//delete the data
		public int deleteById(int id)
		{
			return trepo.deleteId(id);
		}
		
		//update the data
		public Integer updateById(double am,int id)
		{
			return trepo.updateId(am, id);
		}
		
		
		//sorting (ascending)
		public List<Transaction> sortAsc(String name)
		{
			return trepo.findAll(Sort.by(name));
		}
		
		//sorting (descending)
		public List<Transaction> sortDes(String name)
		{
			return trepo.findAll(Sort.by(name).descending());
		}
		
		//pagination
		public List<Transaction> pagination(int pageNum,int pageSize)
		{
			Page<Transaction> trans=trepo.findAll(PageRequest.of(pageNum, pageSize));
			return trans.getContent();
		}
		
		//pagination and sorting
		public List<Transaction> paginationSorting(int pageNum,int pageSize,String name)
		{
			Page<Transaction> trans=trepo.findAll(PageRequest.of(pageNum, pageSize,Sort.by(name)));
			return trans.getContent();
		}

}
