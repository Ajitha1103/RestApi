package com.example.day4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day4.model.kitchenOrg;

public interface KitchenRepo extends JpaRepository<kitchenOrg, Integer>
{

}
