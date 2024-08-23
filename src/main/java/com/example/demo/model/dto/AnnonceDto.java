package com.example.demo.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class AnnonceDto extends BaseDto {

	@NotBlank
	private String Titre;
	@NotBlank
	private String contenu;
	@NotBlank
	private LocalDate datePublication;
	

	@JsonIgnoreProperties("annonce")
	private AdminDto admin;
}
