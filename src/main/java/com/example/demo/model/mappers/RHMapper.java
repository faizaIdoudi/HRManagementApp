package com.example.demo.model.mappers;

import org.modelmapper.ModelMapper;

import com.example.demo.model.dto.RHDto;
import com.example.demo.model.entities.RH;

public class RHMapper {

	private static final ModelMapper modelMapper= new ModelMapper();
	public static RHDto convertToDTO(RH rh)
	{
	return modelMapper.map(rh, RHDto.class);
	}

	public static RH convertToEntity(RHDto rhDTO)
	{
	return modelMapper.map(rhDTO, RH.class);	
	}
}
