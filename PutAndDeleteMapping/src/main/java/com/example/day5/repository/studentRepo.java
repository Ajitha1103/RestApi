package com.example.day5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day5.model.studentModel;


public interface studentRepo extends JpaRepository<studentModel, Integer>{

}
