package com.example.demo.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class CandidatureDto extends BaseDto {


	@NotBlank
	private LocalDate dateCandidature;
	@NotBlank
	private String Statut;
	@NotBlank
	private String Poste;
	@NotBlank
	private String CV;
	@NotBlank
	private String letterMotivation;
	
	@JsonIgnoreProperties("candidature")
    private RHDto rh;

	@JsonIgnoreProperties("candidature")
    private CandidatDto candidat;

}
