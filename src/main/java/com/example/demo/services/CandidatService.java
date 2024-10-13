package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.dto.CandidatDto;

public interface CandidatService {
	
	public CandidatDto addOneCandidat(CandidatDto candidatDto);
	public Page<CandidatDto> getAllCandidats(Pageable pageable);
	public Optional<CandidatDto> getOneCandidat(long id);
	public void deleteOneCandidat(long id);
	public Optional<CandidatDto> findByEmail(String email);

}
