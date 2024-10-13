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

import com.example.demo.model.dto.CandidatDto;
import com.example.demo.services.CandidatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/candidats") 
@RequiredArgsConstructor
public class CandidatController {

	 private final CandidatService candidatService; 

	   
	    public CandidatController(CandidatService candidatService) {
	        this.candidatService = candidatService;
	    }


	    @PostMapping
	    public ResponseEntity<CandidatDto> addCandidat(@RequestBody CandidatDto candidatDto) {
	    	CandidatDto createdCandidat = candidatService.addOneCandidat(candidatDto);
	        return new ResponseEntity<>(createdCandidat, HttpStatus.CREATED);
	    }
	    
	    @GetMapping
	    public ResponseEntity<Page<CandidatDto>> getAllCandidats(Pageable pageable) {
	        Page<CandidatDto> candidats = candidatService.getAllCandidats(pageable);
	        return ResponseEntity.ok(candidats);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<CandidatDto> getCandidatById(@PathVariable long id) {
	        return candidatService.getOneCandidat(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCandidat(@PathVariable long id) {
	    	candidatService.deleteOneCandidat(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    @GetMapping("/email/{email}")
	    public ResponseEntity<CandidatDto> getCandidatByEmail(@PathVariable String email) {
	        return candidatService.findByEmail(email)
	                .map(ResponseEntity::ok)  // If CandidatDto is found, return 200 OK with the DTO
	                .orElseGet(() -> ResponseEntity.notFound().build());  // If not found, return 404
	    }

	    
}
