package com.example.demo.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class AdminDto extends BaseDto{

	@JsonIgnoreProperties("admin")
    private List<EmployeeDto> employees;
    
	@JsonIgnoreProperties("admin")
    private List<RéunionDto> réunions;


	@JsonIgnoreProperties("admin")
    private List<AnnonceDto> annonces;
}
