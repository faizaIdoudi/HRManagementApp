package com.example.demo.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.dto.CongéDto;


public interface CongéService {

	public CongéDto addOne(CongéDto congéDto);
	public Page<CongéDto> getAllCongés(Pageable pageable);
	public void deleteOne(long id);
	public Optional<CongéDto> getCongéById(long id);
}
