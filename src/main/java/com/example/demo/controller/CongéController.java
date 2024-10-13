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

import com.example.demo.model.dto.CongéDto;
import com.example.demo.services.CongéService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/congés") 
@RequiredArgsConstructor
public class CongéController {

	private final CongéService congéService; 

	   
    public CongéController(CongéService congéService) {
        this.congéService = congéService;
    }


    @PostMapping
    public ResponseEntity<CongéDto> addCongé(@RequestBody CongéDto congéDto) {
    	CongéDto createdCongé = congéService.addOne(congéDto);
        return new ResponseEntity<>(createdCongé, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<Page<CongéDto>> getAllCongés(Pageable pageable) {
        Page<CongéDto> congés = congéService.getAllCongés(pageable);
        return ResponseEntity.ok(congés);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CongéDto> getCongéById(@PathVariable long id) {
        return congéService.getCongéById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCongé(@PathVariable long id) {
    	congéService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }
    
}
