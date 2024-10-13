package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.CongéDto;
import com.example.demo.model.entities.Congé;
import com.example.demo.model.mappers.CongéMapper;
import com.example.demo.repository.CongéRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CongéServiceImpl implements CongéService {

    private final CongéRepository congéRepository;
	

    // Constructor Injection
    public CongéServiceImpl(CongéRepository congéRepository) {
        this.congéRepository = congéRepository;
    }

    
	@Override
	public CongéDto addOne(CongéDto congéDto) {
		Congé congé = CongéMapper.convertToEntity(congéDto);
		Congé savedCongé = congéRepository.save(congé);
        return CongéMapper.convertToDTO(savedCongé);
	}

	@Override
	public Page<CongéDto> getAllCongés(Pageable pageable) {
		// TODO Auto-generated method stub
		 Page<Congé> congés = congéRepository.findAll(pageable);
		 return congés.map(CongéMapper::convertToDTO);
	}

	@Override
	public void deleteOne(long id) {
		// TODO Auto-generated method stub
        congéRepository.deleteById(id);
		
	}

	@Override
	public Optional<CongéDto> getCongéById(long id) {
		// TODO Auto-generated method stub
		return congéRepository.findById(id).map(CongéMapper::convertToDTO);
	}

}
