package com.example.demo.model.mappers;

import org.modelmapper.ModelMapper;

import com.example.demo.model.dto.CandidatDto;
import com.example.demo.model.entities.Candidat;

public class CandidatMapper {

	private static final ModelMapper modelMapper= new ModelMapper();
	public static CandidatDto convertToDTO(Candidat candidat)
	{
	return modelMapper.map(candidat, CandidatDto.class);
	}

	public static Candidat convertToEntity(CandidatDto candidatDto)
	{
	return modelMapper.map(candidatDto, Candidat.class);	
	}
}
