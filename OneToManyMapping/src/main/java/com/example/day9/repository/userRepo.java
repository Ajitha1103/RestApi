package com.example.day9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day9.model.usersModel;

public interface userRepo extends JpaRepository<usersModel, Integer>{

}
