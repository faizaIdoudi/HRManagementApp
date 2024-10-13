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

import com.example.demo.model.dto.RéunionDto;
import com.example.demo.services.RéunionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/réunions") 
@RequiredArgsConstructor
public class RéunionController {

	private final RéunionService réunionService; 

	   
    public RéunionController(RéunionService réunionService) {
        this.réunionService = réunionService;
    }


    @PostMapping
    public ResponseEntity<RéunionDto> addRéunion(@RequestBody RéunionDto réunionDto) {
    	RéunionDto createdRéunion = réunionService.addOne(réunionDto);
        return new ResponseEntity<>(createdRéunion, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<Page<RéunionDto>> getAllRéunions(Pageable pageable) {
        Page<RéunionDto> réunions = réunionService.getAllRéunions(pageable);
        return ResponseEntity.ok(réunions);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RéunionDto> getRéunionById(@PathVariable long id) {
        return réunionService.getRéunionById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRéunion(@PathVariable long id) {
    	réunionService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }
    
}
