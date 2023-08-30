package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.project.model.Branch;
import com.example.project.repository.branchRepo;

@Service


public class branchService {
	@Autowired
	public branchRepo brepo;
	
	//post the data
	public String saveBranch(@RequestBody Branch b)
	{
		brepo.save(b);
		return "data is saved";
	}
	
	//get the data
	public List<Branch> getBranch()
	{
		return brepo.findAll();
	}
	
	//sorting (ascending)
			public List<Branch> sortAsc(String name)
			{
				return brepo.findAll(Sort.by(name));
			}
			
			//sorting (descending)
			public List<Branch> sortDes(String name)
			{
				return brepo.findAll(Sort.by(name).descending());
			}
			
			//pagination
			public List<Branch> pagination(int pageNum,int pageSize)
			{
				Page<Branch> bran=brepo.findAll(PageRequest.of(pageNum, pageSize));
				return bran.getContent();
			}
			
			//pagination and sorting
			public List<Branch> paginationSorting(int pageNum,int pageSize,String name)
			{
				Page<Branch> bran=brepo.findAll(PageRequest.of(pageNum, pageSize,Sort.by(name)));
				return bran.getContent();
			}

}
