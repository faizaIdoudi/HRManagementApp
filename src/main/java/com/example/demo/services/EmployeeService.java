package com.example.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;


import com.example.demo.model.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto addOneEmployee(EmployeeDto employeeDto);
	public Page<EmployeeDto> getAllEmployee(Pageable pageable);
	public Optional<EmployeeDto> getOneEmployee(long id);
	public void deleteOneEmployee(long id);
	public Optional<EmployeeDto> findByEmail(String email);
}
