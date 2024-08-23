package com.example.demo.model.mappers;

import org.modelmapper.ModelMapper;


import com.example.demo.model.dto.AnnonceDto;
import com.example.demo.model.entities.Annonce;

public class AnnonceMapper {

	private static final ModelMapper modelMapper= new ModelMapper();
	public static AnnonceDto convertToDTO(Annonce annonce)
	{
	return modelMapper.map(annonce, AnnonceDto.class);
	}

	public static Annonce convertToEntity(AnnonceDto annonceDTO)
	{
	return modelMapper.map(annonceDTO, Annonce.class);	
	}
}
