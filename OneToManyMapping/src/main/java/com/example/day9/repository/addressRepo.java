package com.example.day9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day9.model.addressModel;

public interface addressRepo extends JpaRepository<addressModel, Integer>{

}
