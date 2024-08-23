package com.example.demo.model.dto;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class CandidatDto extends BaseDto{
	
	@NotBlank
	private String NomComplet;
	@Email
	@NotBlank
	private String Email;
	@Size(min = 8,max = 16)
	private String Telephone;
	@NotBlank
	private String poste;
	@NotBlank
	private String NiveauDetude;
	@NotBlank
	private String Adresse;
	
	
	@JsonIgnoreProperties("candidat")
    private List<CandidatureDto> candidatures;

}
