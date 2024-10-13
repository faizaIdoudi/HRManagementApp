package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CandidatDto;
import com.example.demo.model.entities.Candidat;
import com.example.demo.model.mappers.CandidatMapper;
import com.example.demo.repository.CandidatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidatServiceImpl implements CandidatService {
	

    private final CandidatRepository candidatRepository;
	

    // Constructor Injection
    public CandidatServiceImpl(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

	@Override
	public CandidatDto addOneCandidat(CandidatDto candidatDto) {
		Candidat candidat = CandidatMapper.convertToEntity(candidatDto);
		Candidat savedCandidat = candidatRepository.save(candidat);
        return CandidatMapper.convertToDTO(savedCandidat);
	}

	@Override
	public Page<CandidatDto> getAllCandidats(Pageable pageable) {
		 Page<Candidat> candidats = candidatRepository.findAll(pageable);
		    return candidats.map(CandidatMapper::convertToDTO);
	}

	@Override
	public Optional<CandidatDto> getOneCandidat(long id) {
		// TODO Auto-generated method stub
		return candidatRepository.findById(id).map(CandidatMapper::convertToDTO);
	}

	@Override
	public void deleteOneCandidat(long id) {
		// TODO Auto-generated method stub
		
		candidatRepository.deleteById(id);
		
	}

	@Override
	public Optional<CandidatDto> findByEmail(String email) {
		// TODO Auto-generated method stub
		Candidat candidat = candidatRepository.findByEmail(email);

	    if (candidat != null) {
	        return Optional.of(CandidatMapper.convertToDTO(candidat));  
	    }

	    return Optional.empty(); 
	}

}
