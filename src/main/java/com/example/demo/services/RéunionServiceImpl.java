package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.RéunionDto;
import com.example.demo.model.entities.Réunion;
import com.example.demo.model.mappers.RéunionMapper;
import com.example.demo.repository.RéunionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RéunionServiceImpl implements RéunionService {


    private final RéunionRepository réunionRepository;
	

    // Constructor Injection
    public RéunionServiceImpl(RéunionRepository réunionRepository) {
        this.réunionRepository = réunionRepository;
    }

    
	@Override
	public RéunionDto addOne(RéunionDto réunionDto) {
		
		Réunion réunion = RéunionMapper.convertToEntity(réunionDto);
		Réunion savedRéunion = réunionRepository.save(réunion);
        return RéunionMapper.convertToDTO(savedRéunion);
	}

	@Override
	public Page<RéunionDto> getAllRéunions(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Réunion> réunions = réunionRepository.findAll(pageable);
	    return réunions.map(RéunionMapper::convertToDTO);
	}

	@Override
	public void deleteOne(long id) {
		// TODO Auto-generated method stub
		réunionRepository.deleteById(id);
		
	}

	@Override
	public Optional<RéunionDto> getRéunionById(long id) {
		// TODO Auto-generated method stub
		return réunionRepository.findById(id).map(RéunionMapper::convertToDTO);
	}

}
