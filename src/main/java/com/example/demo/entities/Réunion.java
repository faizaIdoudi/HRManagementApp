package com.example.demo.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Réunion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable=false)
	private String Titre;
	@Column(nullable=false)
	private String Type;
	@Column(nullable=false)
	private LocalDate date;
	@Column(nullable=false)
	private LocalTime debut;
	@Column(nullable=false)
	private LocalTime fin;
	
	 @ManyToOne
	 @JoinColumn(name = "admin_id")
	 private Admin admin;


}
