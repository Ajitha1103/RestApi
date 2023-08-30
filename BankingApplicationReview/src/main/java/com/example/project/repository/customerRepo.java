package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project.model.Customer;

import jakarta.transaction.Transactional;

public interface customerRepo extends JpaRepository<Customer, Long> {
	
	//native query(get all rows)
	//@Query(value = "select * from customertable",nativeQuery = true)
	@Query("select c from Customer c")
	public List<Customer> getAllRows();
	
	//get specific rows
	//@Query(value = "select * from customertable where custname=:name and custid=:id",nativeQuery = true)
	@Query("select c from Customer c where c.custname=:name and c.custId=:id")
	public List<Customer> getSpecRows(@Param("name") String name,@Param("id") int id);
	
	//delete the data
	@Modifying
	@Transactional
	@Query(value = "delete from customertable where custid=:id",nativeQuery = true)
	//@Query("select from Customer c where c.custId=:id")
	public int deleteId(@Param("id") int id);
	
	//update the data
	@Modifying
	@Transactional
	@Query(value = "update customertable set custname=:name where custid=:id",nativeQuery = true)
	public Integer updateId(@Param("name") String name,@Param("id") int id);
	

}
