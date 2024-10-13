package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.entities.Employee;
import com.example.demo.model.mappers.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
 


    private final EmployeeRepository employeeRepository;
	

    // Constructor Injection
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto addOneEmployee(EmployeeDto employeeDto) {
      
    	Employee employee = EmployeeMapper.convertToEntity(employeeDto);
    	Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.convertToDTO(savedEmployee);
    }

    @Override
    public Page<EmployeeDto> getAllEmployee(Pageable pageable) {
        // TODO Auto-generated method stub
    	
        Page<Employee> employees = employeeRepository.findAll(pageable);
	    return employees.map(EmployeeMapper::convertToDTO);
       
    }

    @Override
    public Optional<EmployeeDto> getOneEmployee(long id) {
        // TODO Auto-generated method stub
        return employeeRepository.findById(id).map(EmployeeMapper::convertToDTO);
    }

    @Override
    public void deleteOneEmployee(long id) {
        // TODO Auto-generated method stub
    	employeeRepository.deleteById(id);
        
    }

    @Override
    public Optional<EmployeeDto> findByEmail(String email) {
    	Employee employee = employeeRepository.findByEmail(email);

        // If employee is found, convert it to DTO, otherwise return an empty Optional
        return Optional.ofNullable(employee)
                       .map(EmployeeMapper::convertToDTO);
    }

}
