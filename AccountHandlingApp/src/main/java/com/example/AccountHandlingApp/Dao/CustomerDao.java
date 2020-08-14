package com.example.AccountHandlingApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AccountHandlingApp.Entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
