package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.AnnonceDto;
import com.example.demo.model.entities.Annonce;
import com.example.demo.model.mappers.AnnonceMapper;
import com.example.demo.repository.AnnonceRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnnonceServiceImpl implements AnnonceService {

	private final AnnonceRepository annonceRepository;
	
	 // Constructor Injection
    public AnnonceServiceImpl(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    
	@Override
	public AnnonceDto addOne(AnnonceDto annonceDto) {
		Annonce annonce = AnnonceMapper.convertToEntity(annonceDto);
		Annonce savedAnnonce = annonceRepository.save(annonce);
        return AnnonceMapper.convertToDTO(savedAnnonce);
	}

	@Override
	public Page<AnnonceDto> getAllAnnonces(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Annonce> annonces= annonceRepository.findAll(pageable);
		
		return annonces.map(AnnonceMapper::convertToDTO);
	}

	@Override
	public void deleteOne(long id) {
		// TODO Auto-generated method stub
		annonceRepository.deleteById(id);
		
	}

	@Override
	public Optional<AnnonceDto> getAnnonceById(long id) {
		// TODO Auto-generated method stub
		return annonceRepository.findById(id)
	            .map(AnnonceMapper::convertToDTO); 
	}

	@Override
	public Optional<AnnonceDto> findByTitre(String titre) {
		 // TODO Auto-generated method stub
		return Optional.ofNullable(annonceRepository.findByTitre(titre))
	            .map(AnnonceMapper::convertToDTO);
	}

}
