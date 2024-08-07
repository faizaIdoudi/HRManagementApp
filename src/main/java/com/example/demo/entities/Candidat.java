package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Candidat {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable=false)
	private String NomComplet;
	@Email
	private String Email;
	@NotNull
	private String Telephone;
	@NotNull
	private String poste;
	@NotNull
	private String NiveauDetude;
	@NotNull
	private String CV;
	
	@ManyToOne
    @JoinColumn(name = "rh_id")
    private RH rh;
}
