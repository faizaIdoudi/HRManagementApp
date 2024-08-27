package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	  public Employee findByEmail(String email);
}
