package com.example.day8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day8.model.studentModel;

public interface studentRepo extends JpaRepository<studentModel, Integer>{

}
