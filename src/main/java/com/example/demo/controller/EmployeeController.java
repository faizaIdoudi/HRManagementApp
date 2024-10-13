package com.example.demo.controller;


import org.springframework.data.domain.Pageable;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.services.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees") 
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService; 

   
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployee = employeeService.addOneEmployee(employeeDto);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<Page<EmployeeDto>> getAllEmployees(Pageable pageable) {
        Page<EmployeeDto> employees = employeeService.getAllEmployee(pageable);
        return ResponseEntity.ok(employees);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id) {
        return employeeService.getOneEmployee(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
    	employeeService.deleteOneEmployee(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<EmployeeDto> getEmployeeByEmail(@PathVariable String email) {
        return employeeService.findByEmail(email)
        		.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
}

