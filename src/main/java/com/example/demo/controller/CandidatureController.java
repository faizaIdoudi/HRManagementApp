package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.CandidatureDto;
import com.example.demo.services.CandidatureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/candidatures") 
@RequiredArgsConstructor
public class CandidatureController {

	private final CandidatureService candidatureService; 

	   
    public CandidatureController(CandidatureService candidatureService) {
        this.candidatureService = candidatureService;
    }


    @PostMapping
    public ResponseEntity<CandidatureDto> addCandidature(@RequestBody CandidatureDto candidatureDto) {
    	CandidatureDto createdCandidature = candidatureService.addCandidature(candidatureDto);
        return new ResponseEntity<>(createdCandidature, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<Page<CandidatureDto>> getAllCandidatures(Pageable pageable) {
        Page<CandidatureDto> candidatures = candidatureService.getAllCandidatures(pageable);
        return ResponseEntity.ok(candidatures);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CandidatureDto> getCandidatureById(@PathVariable long id) {
        return candidatureService.getCandidatureById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidature(@PathVariable long id) {
    	candidatureService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }
    
}
