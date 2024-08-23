package com.example.demo.model.mappers;

import org.modelmapper.ModelMapper;

import com.example.demo.model.dto.RéunionDto;
import com.example.demo.model.entities.Réunion;

public class RéunionMapper {

	private static final ModelMapper modelMapper= new ModelMapper();
	public static RéunionDto convertToDTO(Réunion réunion)
	{
	return modelMapper.map(réunion, RéunionDto.class);
	}

	public static Réunion convertToEntity(RéunionDto réunionDTO)
	{
	return modelMapper.map(réunionDTO, Réunion.class);	
	}
}
