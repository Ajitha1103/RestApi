package com.example.day6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day6.model.employModel;

public interface employRepo extends JpaRepository<employModel, Integer> {

}
