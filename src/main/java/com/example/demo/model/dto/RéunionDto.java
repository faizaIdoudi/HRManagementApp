package com.example.demo.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class RéunionDto extends BaseDto {

	@NotBlank
	private String Titre;
	@NotBlank
	private String Type;
	@NotBlank
	private LocalDate date;
	@NotBlank
	private LocalTime debut;
	@NotBlank
	private LocalTime fin;
	
	@JsonIgnoreProperties("réunion")
	 private AdminDto admin;

}
