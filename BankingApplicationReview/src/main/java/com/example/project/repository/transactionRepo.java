package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project.model.Transaction;

import jakarta.transaction.Transactional;

public interface transactionRepo extends JpaRepository<Transaction, Long>{
	
	//native query(get all rows)
		@Query(value = "select * from transactiontable",nativeQuery = true)
		public List<Transaction> getAllRows();
		
		//get specific rows
		@Query(value = "select * from transactiontable where description like %?1% ",nativeQuery = true)
		public List<Transaction> getSpecRows(@Param("name") String name);
		
		//delete the data
		@Modifying
		@Transactional
		@Query(value = "delete from transactiontable where transid=:id",nativeQuery = true)
		public int deleteId(@Param("id") int id);
		
		//update the data
		@Modifying
		@Transactional
		@Query(value = "update transactiontable set amount=:am and transid=:id",nativeQuery = true)
		public Integer updateId(@Param("am") double am,@Param("id") int id);
		
		

}
