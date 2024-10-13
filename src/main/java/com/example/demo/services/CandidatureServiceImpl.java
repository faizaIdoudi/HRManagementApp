package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CandidatureDto;
import com.example.demo.model.entities.Candidature;
import com.example.demo.model.mappers.CandidatureMapper;
import com.example.demo.repository.CandidatureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidatureServiceImpl implements CandidatureService {

   private final CandidatureRepository candidatureRepository;
	

    // Constructor Injection
    public CandidatureServiceImpl(CandidatureRepository candidatureRepository) {
        this.candidatureRepository = candidatureRepository;
    }
    
	@Override
	public Page<CandidatureDto> getAllCandidatures(Pageable pageable) {
		
		Page<Candidature> candidatures = candidatureRepository.findAll(pageable);
	    return candidatures.map(CandidatureMapper::convertToDTO);
	}

	@Override
	public Optional<CandidatureDto> getCandidatureById(long id) {
		// TODO Auto-generated method stub
		return candidatureRepository.findById(id).map(CandidatureMapper::convertToDTO);
	}

	@Override
	public CandidatureDto addCandidature(CandidatureDto candidatureDto) {
		Candidature candidature = CandidatureMapper.convertToEntity(candidatureDto);
		Candidature savedCandidature = candidatureRepository.save(candidature);
        return CandidatureMapper.convertToDTO(savedCandidature);
    
	}

	@Override
	public void deleteOne(long id) {
		// TODO Auto-generated method stub
		candidatureRepository.deleteById(id);
		
	}

}
