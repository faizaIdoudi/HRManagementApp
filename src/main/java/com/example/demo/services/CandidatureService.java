package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.dto.CandidatureDto;


public interface CandidatureService {
	
	public Page<CandidatureDto> getAllCandidatures(Pageable pageable);
	public Optional<CandidatureDto> getCandidatureById(long id);
	public CandidatureDto addCandidature(CandidatureDto candidatureDto);
	public void deleteOne(long id);
	

}
