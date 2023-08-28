package com.example.day9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day9.model.collegeModel;

public interface collegeRepo extends JpaRepository<collegeModel, Integer>{

}
