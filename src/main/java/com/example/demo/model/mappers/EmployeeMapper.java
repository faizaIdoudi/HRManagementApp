package com.example.demo.model.mappers;

import org.modelmapper.ModelMapper;

import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.entities.Employee;

public class EmployeeMapper {

	private static final ModelMapper modelMapper= new ModelMapper();
	public static EmployeeDto convertToDTO(Employee employee)
	{
	return modelMapper.map(employee, EmployeeDto.class);
	}

	public static Employee convertToEntity(EmployeeDto employeeDTO)
	{
	return modelMapper.map(employeeDTO, Employee.class);	
	}
}
