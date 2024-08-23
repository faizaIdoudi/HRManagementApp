package com.example.demo.model.mappers;

import org.modelmapper.ModelMapper;

import com.example.demo.model.dto.CongéDto;
import com.example.demo.model.entities.Congé;

public class CongéMapper {

	private static final ModelMapper modelMapper= new ModelMapper();
	public static CongéDto convertToDTO(Congé congé)
	{
	return modelMapper.map(congé, CongéDto.class);
	}

	public static Congé convertToEntity(CongéDto congéDTO)
	{
	return modelMapper.map(congéDTO, Congé.class);	
	}
}
