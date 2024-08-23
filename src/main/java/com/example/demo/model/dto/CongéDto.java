package com.example.demo.model.dto;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class CongéDto extends BaseDto{

	@NotBlank
    private LocalDate dateDebut;

	@NotBlank
    private LocalDate dateFin;

	@NotNull
    private Integer joursDeCongeConsommes;

	@NotNull
    private Integer joursDeCongeRestants;

	@NotBlank
    private String statut;
    
	@JsonIgnoreProperties("congé")
    private EmployeeDto employee;

  
	@JsonIgnoreProperties("congé")
    private RHDto rh;
}
