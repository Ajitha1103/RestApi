package com.example.day7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.day7.model.hotelModel;

import jakarta.transaction.Transactional;

public interface hotelRepo extends JpaRepository<hotelModel, Integer>{
	
	//native query
	@Query(value="select * from hoteltable",nativeQuery = true)
	public List<hotelModel> getAllRows();
	
	//native query
	@Query(value="select * from hoteltable where hotelname like %?1% ",nativeQuery = true)
	
	//using model name
	//@Query("select h from hotelModel h where h.hotelname like %?1%")
	public List<hotelModel> getByName(@Param("name") String name);
	
	//native query
	@Query(value = "select * from hoteltable where hotelname=:n and hoteltype=:t",nativeQuery = true)
	public List<hotelModel> getSpecRows(@Param("n") String n,@Param("t") String t);
	
	//delete using native query
	@Modifying
	@Transactional
	@Query(value="delete from hoteltable where hotelid=:id",nativeQuery = true)
	
	//using model query
	//@Query("delete from hotelModel h where h.hotelId=:id")
	public int deleteId(@Param("id") int id);
	
	//update using native query
	@Modifying
	@Transactional
	@Query(value="update hoteltable set hotelname=:h where hotelid=:id",nativeQuery = true)
	public Integer updateId(@Param("h") String h,@Param("id") int id);
	
//	//get model query
//	@Query(value="select h from hotelModel h",nativeQuery = true)
//	public List<hotelModel>getRows();
	
}
