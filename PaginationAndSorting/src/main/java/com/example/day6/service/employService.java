package com.example.day6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.day6.model.employModel;
import com.example.day6.repository.employRepo;

@Service

public class employService {
	@Autowired
	public employRepo erepo;
	
	//post the data
	public String saveEmployee(@RequestBody employModel em)
	{
		erepo.save(em);
		return "Data is saved";
	}
	
	//sorting (ascending)
	public List<employModel> sortAsc(String name)
	{
		return erepo.findAll(Sort.by(name));
	}
	
	//sorting (descending)
	public List<employModel> sortDes(String name)
	{
		return erepo.findAll(Sort.by(name).descending());
	}
	
	//pagination
	public List<employModel> pagination(int pageNum,int pageSize)
	{
		Page<employModel> emp=erepo.findAll(PageRequest.of(pageNum, pageSize));
		return emp.getContent();
	}
	
	//pagination and sorting
	public List<employModel> paginationSorting(int pageNum,int pageSize,String name)
	{
		Page<employModel> emp=erepo.findAll(PageRequest.of(pageNum, pageSize,Sort.by(name)));
		return emp.getContent();
	}

}
