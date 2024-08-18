package com.example.demo.model.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.demo.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitialiser","handler"})
public class Réunion extends BaseEntity  {
	
	
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
