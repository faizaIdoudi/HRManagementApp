package com.example.demo.model.dto;

import java.util.List;

import com.example.demo.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class EmployeeDto extends BaseDto{

	
	@NotBlank
	private String NomComplet;
	@Email
	@NotBlank
	private String Email;
	@JsonIgnoreProperties(allowSetters  = true,value="password")
	@NotBlank
	@Size(min = 8)
	private String password;
	@Size(min = 8,max = 16)
	private String Telephone;
	@NotBlank
	private String poste;
	@NotBlank
    private Role role;

	@JsonIgnoreProperties("employee")
    private List<CongéDto> congés;
    
	@JsonIgnoreProperties("employee")
    private AdminDto admin;

}
