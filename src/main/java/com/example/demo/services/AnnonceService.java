package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.dto.AnnonceDto;


public interface AnnonceService {

	public AnnonceDto addOne(AnnonceDto annonceDto);
	public Page<AnnonceDto> getAllAnnonces(Pageable pageable);
	public void deleteOne(long id);
	public Optional<AnnonceDto> getAnnonceById(long id);
	public Optional<AnnonceDto> findByTitre(String titre);
}
