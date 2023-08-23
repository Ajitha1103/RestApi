package com.example.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pro.model.bankModel;

public interface bankRepo extends JpaRepository<bankModel, Integer> {

}
