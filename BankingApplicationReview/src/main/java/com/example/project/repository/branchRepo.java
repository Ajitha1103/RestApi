package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.Branch;

public interface branchRepo extends JpaRepository<Branch, Long>{

}
