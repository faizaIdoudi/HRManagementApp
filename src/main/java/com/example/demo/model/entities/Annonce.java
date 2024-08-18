package com.example.demo.model.entities;

import java.time.LocalDate;

import com.example.demo.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
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
public class Annonce extends BaseEntity {
	
	
	@NotNull
	private String Titre;
	@NotNull
	private String contenu;
	@NotNull
	private LocalDate datePublication;
	
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;

}
