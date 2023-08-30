package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project.model.Account;
import jakarta.transaction.Transactional;

public interface accountRepo extends JpaRepository<Account, Long> {
	
	//native query
	//get all rows
	@Query(value = "select * from accounttable",nativeQuery = true)
	//@Query("select * from Account")
	public List<Account> getAllRows();
	
	//get specific data
	@Query(value = "select * from accounttable where accholdername=:name and accountid=:id",nativeQuery = true)
	public List<Account> getSpecRows(@Param("name") String name,@Param("id") int id);
	
	//get by account holder name
	@Query(value = "select * from accounttable where accholdername like %?1%",nativeQuery = true)
	//@Query("select * from Account a where a.accholdername like %?1%")
	public List<Account> getByAccname();
	
	//delete the data
	@Modifying
	@Transactional
	@Query(value = "delete from accounttable where accountid=:id",nativeQuery = true)
	public int deleteId(@Param("id") int id);
		
	//update the data
	@Modifying
	@Transactional
	@Query(value = "update accounttable set accholdername=:name where accountid=:id",nativeQuery = true)
	public Integer updateId(@Param("name") String name,@Param("id") int id);

}
