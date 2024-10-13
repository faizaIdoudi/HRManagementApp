package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.example.demo.model.dto.RéunionDto;



public interface RéunionService {
	
	public RéunionDto addOne(RéunionDto réunionDto);
	public Page<RéunionDto> getAllRéunions(Pageable pageable);
	public void deleteOne(long id);
	public Optional<RéunionDto> getRéunionById(long id);

}
