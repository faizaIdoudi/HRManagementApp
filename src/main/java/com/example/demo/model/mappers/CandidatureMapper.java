package com.example.demo.model.mappers;

import org.modelmapper.ModelMapper;

import com.example.demo.model.dto.CandidatureDto;
import com.example.demo.model.entities.Candidature;

public class CandidatureMapper {

	private static final ModelMapper modelMapper= new ModelMapper();
	public static CandidatureDto convertToDTO(Candidature candidature)
	{
	return modelMapper.map(candidature, CandidatureDto.class);
	}

	public static Candidature convertToEntity(CandidatureDto candidatureDTO)
	{
	return modelMapper.map(candidatureDTO, Candidature.class);	
	}
}
