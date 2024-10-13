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

import com.example.demo.model.dto.AnnonceDto;
import com.example.demo.services.AnnonceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/annonces") 
@RequiredArgsConstructor
public class AnnonceController {

	private final AnnonceService annonceService;
	
	public AnnonceController(AnnonceService annonceService) {
		
		this.annonceService = annonceService;
		
	}
	
	 @PostMapping
	    public ResponseEntity<AnnonceDto> addOne(@RequestBody AnnonceDto annonceDto) {
		    AnnonceDto createdAnnonce = annonceService.addOne(annonceDto);
	        return new ResponseEntity<>(createdAnnonce, HttpStatus.CREATED);
	    }
	 
	 @GetMapping
	    public ResponseEntity<Page<AnnonceDto>> getAllAnnonces(Pageable pageable) {
	        Page<AnnonceDto> annonces = annonceService.getAllAnnonces(pageable);
	        return ResponseEntity.ok(annonces);
	    }
	    
	 @GetMapping("/{id}")
	 public ResponseEntity<AnnonceDto> getAnnonce(@PathVariable long id) {
		 return annonceService.getAnnonceById(id)
		            .map(ResponseEntity::ok)  // If present, wrap in ResponseEntity.ok
		            .orElseGet(() -> ResponseEntity.notFound().build());  
		
	 }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteAnnonce(@PathVariable long id) {
	    	annonceService.deleteOne(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    @GetMapping("/titre/{titre}")
	    public ResponseEntity<AnnonceDto> getAnnonceByTitre(@PathVariable String titre) {
	        return annonceService.findByTitre(titre)
	                .map(ResponseEntity::ok)  // If AnnonceDto is found, return 200 OK with the DTO
	                .orElseGet(() -> ResponseEntity.notFound().build());  // If not found, return 404
	    }

	    
}
