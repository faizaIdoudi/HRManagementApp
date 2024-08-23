package com.example.demo.model.mappers;
import org.modelmapper.ModelMapper;

import com.example.demo.model.dto.AdminDto;
import com.example.demo.model.entities.Admin;

public class AdminMapper {

	private static final ModelMapper modelMapper= new ModelMapper();
	public static AdminDto convertToDTO(Admin admin)
	{
	return modelMapper.map(admin, AdminDto.class);
	}

	public static Admin convertToEntity(AdminDto adminDTO)
	{
	return modelMapper.map(adminDTO, Admin.class);	
	}
}
