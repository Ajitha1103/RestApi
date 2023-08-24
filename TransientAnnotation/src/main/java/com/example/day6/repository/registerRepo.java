package com.example.day6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day6.model.registerModel;

public interface registerRepo extends JpaRepository<registerModel, Integer>{

}
